package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.ConnectionSpec;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.Network;
import com.squareup.okhttp.internal.RouteDatabase;
import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLProtocolException;

public final class RouteSelector {
    private final Address address;
    private final OkHttpClient client;
    private List<ConnectionSpec> connectionSpecs = Collections.emptyList();
    private List<InetSocketAddress> inetSocketAddresses = Collections.emptyList();
    private InetSocketAddress lastInetSocketAddress;
    private Proxy lastProxy;
    private ConnectionSpec lastSpec;
    private final Network network;
    private int nextInetSocketAddressIndex;
    private int nextProxyIndex;
    private int nextSpecIndex;
    private final List<Route> postponedRoutes = new ArrayList();
    private List<Proxy> proxies = Collections.emptyList();
    private final Request request;
    private final RouteDatabase routeDatabase;
    private final URI uri;

    private RouteSelector(Address address2, URI uri2, OkHttpClient client2, Request request2) {
        this.address = address2;
        this.uri = uri2;
        this.client = client2;
        this.routeDatabase = Internal.instance.routeDatabase(client2);
        this.network = Internal.instance.network(client2);
        this.request = request2;
        resetNextProxy(uri2, address2.getProxy());
    }

    public static RouteSelector get(Address address2, Request request2, OkHttpClient client2) throws IOException {
        return new RouteSelector(address2, request2.uri(), client2, request2);
    }

    public boolean hasNext() {
        return hasNextConnectionSpec() || hasNextInetSocketAddress() || hasNextProxy() || hasNextPostponed();
    }

    public Route next() throws IOException {
        if (!hasNextConnectionSpec()) {
            if (!hasNextInetSocketAddress()) {
                if (hasNextProxy()) {
                    this.lastProxy = nextProxy();
                } else if (hasNextPostponed()) {
                    return nextPostponed();
                } else {
                    throw new NoSuchElementException();
                }
            }
            this.lastInetSocketAddress = nextInetSocketAddress();
        }
        this.lastSpec = nextConnectionSpec();
        Route route = new Route(this.address, this.lastProxy, this.lastInetSocketAddress, this.lastSpec, shouldSendTlsFallbackIndicator(this.lastSpec));
        if (!this.routeDatabase.shouldPostpone(route)) {
            return route;
        }
        this.postponedRoutes.add(route);
        return next();
    }

    private boolean shouldSendTlsFallbackIndicator(ConnectionSpec connectionSpec) {
        if (connectionSpec == this.connectionSpecs.get(0) || !connectionSpec.isTls()) {
            return false;
        }
        return true;
    }

    public void connectFailed(Route failedRoute, IOException failure) {
        if (!(failedRoute.getProxy().type() == Proxy.Type.DIRECT || this.address.getProxySelector() == null)) {
            this.address.getProxySelector().connectFailed(this.uri, failedRoute.getProxy().address(), failure);
        }
        this.routeDatabase.failed(failedRoute);
        if (!(failure instanceof SSLHandshakeException) && !(failure instanceof SSLProtocolException)) {
            while (this.nextSpecIndex < this.connectionSpecs.size()) {
                List<ConnectionSpec> list = this.connectionSpecs;
                int i = this.nextSpecIndex;
                this.nextSpecIndex = i + 1;
                ConnectionSpec connectionSpec = list.get(i);
                this.routeDatabase.failed(new Route(this.address, this.lastProxy, this.lastInetSocketAddress, connectionSpec, shouldSendTlsFallbackIndicator(connectionSpec)));
            }
        }
    }

    private void resetNextProxy(URI uri2, Proxy proxy) {
        if (proxy != null) {
            this.proxies = Collections.singletonList(proxy);
        } else {
            this.proxies = new ArrayList();
            List<Proxy> selectedProxies = this.client.getProxySelector().select(uri2);
            if (selectedProxies != null) {
                this.proxies.addAll(selectedProxies);
            }
            this.proxies.removeAll(Collections.singleton(Proxy.NO_PROXY));
            this.proxies.add(Proxy.NO_PROXY);
        }
        this.nextProxyIndex = 0;
    }

    private boolean hasNextProxy() {
        return this.nextProxyIndex < this.proxies.size();
    }

    private Proxy nextProxy() throws IOException {
        if (!hasNextProxy()) {
            throw new SocketException("No route to " + this.address.getUriHost() + "; exhausted proxy configurations: " + this.proxies);
        }
        List<Proxy> list = this.proxies;
        int i = this.nextProxyIndex;
        this.nextProxyIndex = i + 1;
        Proxy result = list.get(i);
        resetNextInetSocketAddress(result);
        return result;
    }

    private void resetNextInetSocketAddress(Proxy proxy) throws IOException {
        int socketPort;
        String socketHost;
        this.inetSocketAddresses = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            socketHost = this.address.getUriHost();
            socketPort = Util.getEffectivePort(this.uri);
        } else {
            SocketAddress proxyAddress = proxy.address();
            if (!(proxyAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + proxyAddress.getClass());
            }
            InetSocketAddress proxySocketAddress = (InetSocketAddress) proxyAddress;
            socketHost = getHostString(proxySocketAddress);
            socketPort = proxySocketAddress.getPort();
        }
        if (socketPort < 1 || socketPort > 65535) {
            throw new SocketException("No route to " + socketHost + ":" + socketPort + "; port is out of range");
        }
        for (InetAddress inetAddress : this.network.resolveInetAddresses(socketHost)) {
            this.inetSocketAddresses.add(new InetSocketAddress(inetAddress, socketPort));
        }
        this.nextInetSocketAddressIndex = 0;
    }

    static String getHostString(InetSocketAddress socketAddress) {
        InetAddress address2 = socketAddress.getAddress();
        if (address2 == null) {
            return socketAddress.getHostName();
        }
        return address2.getHostAddress();
    }

    private boolean hasNextInetSocketAddress() {
        return this.nextInetSocketAddressIndex < this.inetSocketAddresses.size();
    }

    private InetSocketAddress nextInetSocketAddress() throws IOException {
        if (!hasNextInetSocketAddress()) {
            throw new SocketException("No route to " + this.address.getUriHost() + "; exhausted inet socket addresses: " + this.inetSocketAddresses);
        }
        List<InetSocketAddress> list = this.inetSocketAddresses;
        int i = this.nextInetSocketAddressIndex;
        this.nextInetSocketAddressIndex = i + 1;
        InetSocketAddress result = list.get(i);
        resetConnectionSpecs();
        return result;
    }

    private void resetConnectionSpecs() {
        this.connectionSpecs = new ArrayList();
        List<ConnectionSpec> specs = this.address.getConnectionSpecs();
        int size = specs.size();
        for (int i = 0; i < size; i++) {
            ConnectionSpec spec = specs.get(i);
            if (this.request.isHttps() == spec.isTls()) {
                this.connectionSpecs.add(spec);
            }
        }
        this.nextSpecIndex = 0;
    }

    private boolean hasNextConnectionSpec() {
        return this.nextSpecIndex < this.connectionSpecs.size();
    }

    private ConnectionSpec nextConnectionSpec() throws IOException {
        if (this.connectionSpecs.isEmpty()) {
            throw new UnknownServiceException("No route to " + (this.uri.getScheme() != null ? this.uri.getScheme() + "://" : "//") + this.address.getUriHost() + "; no connection specs");
        } else if (!hasNextConnectionSpec()) {
            throw new SocketException("No route to " + (this.uri.getScheme() != null ? this.uri.getScheme() + "://" : "//") + this.address.getUriHost() + "; exhausted connection specs: " + this.connectionSpecs);
        } else {
            List<ConnectionSpec> list = this.connectionSpecs;
            int i = this.nextSpecIndex;
            this.nextSpecIndex = i + 1;
            return list.get(i);
        }
    }

    private boolean hasNextPostponed() {
        return !this.postponedRoutes.isEmpty();
    }

    private Route nextPostponed() {
        return this.postponedRoutes.remove(0);
    }
}
