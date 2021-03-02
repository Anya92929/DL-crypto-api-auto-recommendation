package com.myip.vpnroot;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.AccountPicker;
import com.myip.vpnroot.model.Product;
import com.myip.vpnroot.util.GoogleAuth;
import com.myip.vpnroot.util.GoogleGetName;
import com.myip.vpnroot.util.ObscuredSharedPreferences;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class ServicesActivity extends Fragment {
    private static final int ACCOUNT_CODE = 1601;
    private static final int ACCOUNT_SELECT_CODE = 33;
    private static final int AUTHORIZATION_CODE = 1993;
    private static final int OPENVPN_REQUEST_CODE = 1212;
    private static final String SCOPE = "oauth2:https://www.googleapis.com/auth/userinfo.profile";
    private static final String TAG = "MyIP";
    private static final int VPN_REQUEST_CODE = 121;
    private AccountManager accountManager;
    /* access modifiers changed from: private */
    public String accountName;
    AccountManager mAccountManager;
    /* access modifiers changed from: private */
    public ProgressDialog mProgressDialog;
    private SharedPreferences prefs;
    ListView prodList;
    /* access modifiers changed from: private */
    public ArrayList<Product> prods;
    /* access modifiers changed from: private */
    public ServicesAdapter prods_adapter;
    /* access modifiers changed from: private */
    public String selected_ipv4;
    /* access modifiers changed from: private */
    public String selected_name;
    /* access modifiers changed from: private */
    public String selected_prod;
    int serverCode;
    String token;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(C2344R.layout.activity_services, container, false);
        this.prodList = (ListView) rootView.findViewById(C2344R.C2346id.lv_prods);
        this.prefs = new ObscuredSharedPreferences(getActivity(), getActivity().getSharedPreferences("myip.cfg", 0));
        this.accountName = this.prefs.getString("accountName", (String) null);
        this.prods = new ArrayList<>();
        this.prods_adapter = new ServicesAdapter(this.prods);
        this.prodList.setAdapter(this.prods_adapter);
        this.prodList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String unused = ServicesActivity.this.selected_ipv4 = ((Product) ServicesActivity.this.prods.get(position)).getIpv4().toString();
                String unused2 = ServicesActivity.this.selected_name = ((Product) ServicesActivity.this.prods.get(position)).getHostname().toString();
                String unused3 = ServicesActivity.this.selected_prod = ((Product) ServicesActivity.this.prods.get(position)).getName().toString();
                if (ServicesActivity.this.selected_prod.toString().contains("Personal VPN")) {
                    String unused4 = ServicesActivity.this.selected_ipv4 = ServicesActivity.this.selected_name;
                }
                ServicesActivity.this.configure_vpn(ServicesActivity.this.selected_prod, ServicesActivity.this.selected_name, ServicesActivity.this.selected_ipv4, ServicesActivity.this.accountName);
            }
        });
        this.accountManager = AccountManager.get(getActivity());
        return rootView;
    }

    public void configure_vpn(String product_name, final String hostname, String ipv4, final String username) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Configure");
        builder.setMessage("\nPush VPN Profile on:\n");
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.setPositiveButton("VpnROOT", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                if (ServicesActivity.this.isPackageExisted("com.did.vpnroot")) {
                    Intent myIntent = new Intent();
                    myIntent.setClassName("com.did.vpnroot", "com.did.vpnroot.VpnRootActivity");
                    Bundle conData = new Bundle();
                    try {
                        mCrypt mcrypt = new mCrypt();
                        conData.putString("ipv4", mCrypt.bytesToHex(mcrypt.encrypt(ServicesActivity.this.selected_ipv4)));
                        conData.putString("name", mCrypt.bytesToHex(mcrypt.encrypt(hostname)));
                        conData.putString("username", mCrypt.bytesToHex(mcrypt.encrypt(username)));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    myIntent.putExtras(conData);
                    ServicesActivity.this.startActivityForResult(myIntent, ServicesActivity.VPN_REQUEST_CODE);
                    return;
                }
                new AlertDialog.Builder(ServicesActivity.this.getActivity()).setTitle("Error").setMessage("\nVpnRoot is not installed !\n").setPositiveButton("Install", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        ServicesActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.did.vpnroot")));
                    }
                }).setNegativeButton(17039360, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }).setIcon(17301543).show();
            }
        });
        builder.setNeutralButton("OpenVPN", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                if (ServicesActivity.this.isPackageExisted("de.blinkt.openvpn") || ServicesActivity.this.isPackageExisted("net.openvpn.openvpn")) {
                    ServicesActivity.this.GetProfile(ServicesActivity.this.selected_ipv4, ServicesActivity.this.accountName);
                } else {
                    new AlertDialog.Builder(ServicesActivity.this.getActivity()).setTitle("Error").setMessage("\nOPENVPN is not installed !\n").setPositiveButton("Install", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            ServicesActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=de.blinkt.openvpn")));
                        }
                    }).setNegativeButton(17039360, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    }).setIcon(17301543).show();
                }
            }
        });
        builder.setIcon(17301543);
        builder.show();
    }

    private class ServicesAdapter extends BaseAdapter {
        ArrayList<Product> prods;

        public ServicesAdapter(ArrayList<Product> prods2) {
            this.prods = prods2;
        }

        public int getCount() {
            return this.prods.size();
        }

        public Object getItem(int position) {
            return this.prods.get(position);
        }

        public long getItemId(int position) {
            return (long) this.prods.get(position).getId();
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            Holder holder;
            if (convertView == null) {
                convertView = ServicesActivity.this.getActivity().getLayoutInflater().inflate(C2344R.layout.row_product, (ViewGroup) null);
                holder = new Holder();
                holder.image = (ImageView) convertView.findViewById(C2344R.C2346id.iv_image);
                holder.name = (TextView) convertView.findViewById(C2344R.C2346id.tv_name);
                holder.hostname = (TextView) convertView.findViewById(C2344R.C2346id.tv_name1);
                holder.ipv4 = (TextView) convertView.findViewById(C2344R.C2346id.tv_name2);
                holder.ipv6 = (TextView) convertView.findViewById(C2344R.C2346id.tv_name3);
                holder.status = (TextView) convertView.findViewById(C2344R.C2346id.tv_name4);
                convertView.setTag(holder);
            } else {
                holder = (Holder) convertView.getTag();
            }
            Product prod = (Product) getItem(position);
            holder.name.setText("Service: " + prod.getName());
            holder.hostname.setText("Host: " + prod.getHostname());
            holder.ipv4.setText("IPv4: " + prod.getIpv4());
            holder.ipv6.setText("IPv6: " + prod.getIpv6());
            holder.status.setText("Status: " + prod.getStatus());
            return convertView;
        }

        private class Holder {
            TextView hostname;
            ImageView image;
            TextView ipv4;
            TextView ipv6;
            TextView name;
            TextView status;

            private Holder() {
            }
        }
    }

    public void selectGoogleAccount() {
        if (this.accountName == null) {
            startActivityForResult(AccountPicker.newChooseAccountIntent((Account) null, (ArrayList<Account>) null, new String[]{GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE}, false, (String) null, (String) null, (String[]) null, (Bundle) null), 33);
            return;
        }
        GetServices(this.accountName);
    }

    private GoogleGetName getTask(MainActivity activity, String email, String scope) {
        return new GoogleAuth(activity, email, scope) {
        };
    }

    private class OnTokenAcquired implements AccountManagerCallback<Bundle> {
        private OnTokenAcquired() {
        }

        public void run(AccountManagerFuture<Bundle> result) {
            try {
                Bundle bundle = result.getResult();
                Intent launch = (Intent) bundle.get("intent");
                if (launch != null) {
                    ServicesActivity.this.startActivityForResult(launch, ServicesActivity.AUTHORIZATION_CODE);
                    return;
                }
                String string = bundle.getString("authtoken");
                Toast.makeText(ServicesActivity.this.getActivity(), "Google account " + ServicesActivity.this.accountName + "authorized.", 0).show();
            } catch (Exception e) {
                Toast.makeText(ServicesActivity.this.getActivity(), "Google account " + ServicesActivity.this.accountName + "not authorized.", 0).show();
                throw new RuntimeException(e);
            }
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        int i = 0;
        if (requestCode == VPN_REQUEST_CODE) {
            int found = data.getIntExtra("found", 0);
            configure_vpn(this.selected_prod, this.selected_name, this.selected_ipv4, this.accountName);
            if (found == 0) {
                show_dialog("Error", "\nCan not import profile in VpnRoot !\n");
            } else {
                show_dialog("Info", "\nProfile imported in VpnRoot !\n");
            }
        }
        if (requestCode == OPENVPN_REQUEST_CODE) {
            configure_vpn(this.selected_prod, this.selected_name, this.selected_ipv4, this.accountName);
            show_dialog("Info", "\nProfile imported in OpenVPN !\n");
        }
        if (requestCode == 33) {
            getActivity();
            if (resultCode == -1) {
                this.accountName = data.getStringExtra("authAccount");
                Account[] accountsByType = this.accountManager.getAccountsByType(GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE);
                int length = accountsByType.length;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    Account account = accountsByType[i];
                    if (account.name.equals(this.accountName)) {
                        Account userAccount = account;
                        break;
                    }
                    i++;
                }
                if (this.accountName != null && !this.accountName.isEmpty()) {
                    this.prefs.edit().putString("accountName", this.accountName).commit();
                    GetServices(this.accountName);
                }
            }
        }
    }

    public void onResume() {
        super.onResume();
        if (isVisible()) {
            this.prefs = new ObscuredSharedPreferences(getActivity(), getActivity().getSharedPreferences("myip.cfg", 0));
            this.accountName = this.prefs.getString("accountName", (String) null);
            selectGoogleAccount();
        }
    }

    public void GetServices(String email) {
        this.mProgressDialog = initializeRegisterDialog("Getting services from myIP.io...");
        this.mProgressDialog.show();
        mCrypt mcrypt = new mCrypt();
        String[] strArr = new String[6];
        final List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("action", "getservices"));
        try {
            params.add(new BasicNameValuePair("email", mCrypt.bytesToHex(mcrypt.encrypt(email))));
        } catch (Exception e) {
            e.printStackTrace();
        }
        new AsyncTask<String, Void, String>() {
            String out;

            /* access modifiers changed from: protected */
            public String doInBackground(String... params2) {
                this.out = Utils.notifyWeb(params);
                return "";
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(String out_web) {
                if (ServicesActivity.this.mProgressDialog != null && ServicesActivity.this.mProgressDialog.isShowing()) {
                    ServicesActivity.this.mProgressDialog.dismiss();
                }
                try {
                    this.out = new String(new mCrypt().decrypt(this.out));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ServicesActivity.this.prods.clear();
                String[] tmp = this.out.split("\n");
                String service_name = "";
                String service_ipv4 = "";
                String service_hostname = "";
                String service_status = "";
                for (int i = 0; i < tmp.length; i++) {
                    if (tmp[i].contains("error")) {
                        ServicesActivity.this.show_dialog("Error", tmp[i].split("\\|")[1].toString());
                    }
                    if (tmp[i].contains("service_name")) {
                        service_name = tmp[i].split("\\|")[1].toString();
                    }
                    if (tmp[i].contains("service_hostname")) {
                        service_hostname = tmp[i].split("\\|")[1].toString();
                    }
                    if (tmp[i].contains("service_ipv4")) {
                        service_ipv4 = tmp[i].split("\\|")[1].toString();
                    }
                    if (tmp[i].contains("status")) {
                        service_status = tmp[i].split("\\|")[1].toString();
                    }
                    if (tmp[i].contains("service_ipv6")) {
                        String service_ipv6 = tmp[i].split("\\|")[1].toString();
                        Product temp = new Product();
                        temp.setName(service_name);
                        temp.setHostname(service_hostname);
                        temp.setIpv4(service_ipv4);
                        temp.setIpv6(service_ipv6);
                        temp.setStatus(service_status);
                        ServicesActivity.this.prods.add(temp);
                    }
                }
                ServicesActivity.this.prods_adapter.notifyDataSetChanged();
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{null, null, null});
    }

    public void GetProfile(final String ipv4, String email) {
        this.mProgressDialog = initializeRegisterDialog("Getting Profile from myIP.io...");
        this.mProgressDialog.show();
        mCrypt mcrypt = new mCrypt();
        String[] strArr = new String[6];
        final List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("action", "getprofile"));
        try {
            params.add(new BasicNameValuePair("email", mCrypt.bytesToHex(mcrypt.encrypt(email))));
            params.add(new BasicNameValuePair("ipv4", mCrypt.bytesToHex(mcrypt.encrypt(ipv4))));
        } catch (Exception e) {
            e.printStackTrace();
        }
        new AsyncTask<String, Void, String>() {
            String out;

            /* access modifiers changed from: protected */
            public String doInBackground(String... params2) {
                this.out = Utils.notifyWeb(params);
                return "";
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(String out_web) {
                if (ServicesActivity.this.mProgressDialog != null && ServicesActivity.this.mProgressDialog.isShowing()) {
                    ServicesActivity.this.mProgressDialog.dismiss();
                }
                try {
                    this.out = new String(new mCrypt().decrypt(this.out));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                StringBuffer temp_file = new StringBuffer();
                String[] tmp = this.out.split("\n");
                for (int i = 0; i < tmp.length; i++) {
                    if (tmp[i].contains("error")) {
                        ServicesActivity.this.show_dialog("Error", tmp[i].split("\\|")[1].toString());
                    } else {
                        temp_file.append(tmp[i] + "\n");
                    }
                }
                File myIPDirectory = new File("/sdcard/myip/");
                myIPDirectory.mkdirs();
                try {
                    try {
                        new FileOutputStream(new File(myIPDirectory, ipv4 + ".ovpn")).write(temp_file.toString().getBytes());
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (FileNotFoundException e3) {
                    e3.printStackTrace();
                }
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(Uri.parse("file:///sdcard/myip/" + ipv4 + ".ovpn"), "application/x-openvpn-profile");
                ServicesActivity.this.startActivityForResult(intent, ServicesActivity.OPENVPN_REQUEST_CODE);
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{null, null, null});
    }

    public void show_dialog(String title, String message) {
        new AlertDialog.Builder(getActivity()).setTitle(title).setMessage(message).setPositiveButton(17039370, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        }).setIcon(17301543).show();
    }

    private ProgressDialog initializeRegisterDialog(String msg) {
        ProgressDialog dialog = new ProgressDialog(getActivity());
        dialog.setIndeterminate(true);
        dialog.setMessage(msg.toString());
        return dialog;
    }

    public boolean isPackageExisted(String targetPackage) {
        for (ApplicationInfo packageInfo : getActivity().getPackageManager().getInstalledApplications(0)) {
            if (packageInfo.packageName.equals(targetPackage)) {
                return true;
            }
        }
        return false;
    }
}
