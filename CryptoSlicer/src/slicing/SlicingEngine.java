package slicing;

import javafx.util.Pair;
import main.analyzer.backward.MethodWrapper;
import main.rule.engine.Criteria;
import main.slicer.backward.MethodCallSiteInfo;
import main.slicer.backward.SlicingCriteria;
import main.util.NamedMethodMap;
import main.util.Utils;
import resultWrapper.ResultInMethod;
import resultWrapper.Slice;
import soot.*;
import soot.options.Options;
import soot.toolkits.graph.ExceptionalUnitGraph;
import soot.toolkits.graph.UnitGraph;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SlicingEngine{

    public static final List<String> CRITERIA_CLASSES = new ArrayList<>();
    public static List<Criteria> CRITERIA_LIST = new ArrayList<>();
    public static Map<SootMethod, ResultInMethod> analysisResult = new HashMap<SootMethod,ResultInMethod>();
    public static int MAX_CALLER_DEP=6;
    public static BufferedWriter writer;
    public static BufferedWriter dfgWriter;
    public static boolean debug_flag = true;
    public static SlicingCriteria currentBeginningCriteria;
    public static int sliceCount = 0;
    public static int MAX_SLICE_FOR_EACH_CRITERIA = 11;
    public static Logger log = Logger.getLogger("CryptoSlicerLogger");
    public static int realSliceCount =0;





    static{

        CRITERIA_CLASSES.add("javax.crypto.Cipher");
        CRITERIA_CLASSES.add("java.security.MessageDigest");
        CRITERIA_CLASSES.add("javax.crypto.spec.SecretKeySpec");
        CRITERIA_CLASSES.add("javax.crypto.spec.PBEKeySpec");
        CRITERIA_CLASSES.add("java.security.KeyPairGenerator");
        CRITERIA_CLASSES.add("java.net.URL");
        CRITERIA_CLASSES.add("okhttp3.Request$Builder");
        CRITERIA_CLASSES.add("retrofit2.Retrofit$Builder");
        CRITERIA_CLASSES.add("javax.crypto.spec.PBEParameterSpec");
        CRITERIA_CLASSES.add("javax.crypto.spec.IvParameterSpec");
        CRITERIA_CLASSES.add("java.security.KeyStore");
        CRITERIA_CLASSES.add("java.security.SecureRandom");


        CRITERIA_CLASSES.add("javax.crypto.SecretKey");
        CRITERIA_CLASSES.add("javax.crypto.CipherInputStream");
        CRITERIA_CLASSES.add("javax.crypto.CipherOutputStream");
        CRITERIA_CLASSES.add("javax.crypto.CipherSpi");
        CRITERIA_CLASSES.add("javax.crypto.EncryptedPrivateKeyInfo");
        CRITERIA_CLASSES.add("javax.crypto.ExemptionMechanism");
        CRITERIA_CLASSES.add("javax.crypto.ExemptionMechanismSpi");
        CRITERIA_CLASSES.add("javax.crypto.KeyAgreement");
        CRITERIA_CLASSES.add("javax.crypto.KeyAgreementSpi");
        CRITERIA_CLASSES.add("javax.crypto.KeyGenerator");
        CRITERIA_CLASSES.add("javax.crypto.KeyGeneratorSpi");
        CRITERIA_CLASSES.add("javax.crypto.Mac");
        CRITERIA_CLASSES.add("javax.crypto.MacSpi");
        CRITERIA_CLASSES.add("javax.crypto.NullCipher");
        CRITERIA_CLASSES.add("javax.crypto.SealedObject");
        CRITERIA_CLASSES.add("javax.crypto.SecretKeyFactory");
        CRITERIA_CLASSES.add("javax.crypto.SecretKeyFactorySpi");

        CRITERIA_CLASSES.add("java.security.acl.Acl");
        CRITERIA_CLASSES.add("java.security.acl.AclEntry");
        CRITERIA_CLASSES.add("java.security.acl.Group");
        CRITERIA_CLASSES.add("java.security.acl.Owner");
        CRITERIA_CLASSES.add("java.security.acl.Permission");

        CRITERIA_CLASSES.add("java.security.AlgorithmConstraints");
        CRITERIA_CLASSES.add("java.security.Certificate");
        CRITERIA_CLASSES.add("java.security.DomainCombiner");
        CRITERIA_CLASSES.add("java.security.Guard");
        CRITERIA_CLASSES.add("java.security.Key");
        CRITERIA_CLASSES.add("java.security.KeyStore$Entry");
        CRITERIA_CLASSES.add("java.security.KeyStore$Entry$Attribute");
        CRITERIA_CLASSES.add("java.security.KeyStore$LoadStoreParameter");
        CRITERIA_CLASSES.add("java.security.KeyStore$ProtectionParameter");
        CRITERIA_CLASSES.add("java.security.Policy$Parameters");
        CRITERIA_CLASSES.add("java.security.Principal");
        CRITERIA_CLASSES.add("java.security.PrivateKey");
        CRITERIA_CLASSES.add("java.security.PublicKey");
        CRITERIA_CLASSES.add("java.security.AccessControlContext");
        CRITERIA_CLASSES.add("java.security.AccessController");
        CRITERIA_CLASSES.add("java.security.AlgorithmParameterGenerator");
        CRITERIA_CLASSES.add("java.security.AlgorithmParameterGeneratorSpi");
        CRITERIA_CLASSES.add("java.security.AlgorithmParameters");
        CRITERIA_CLASSES.add("java.security.AlgorithmParametersSpi");
        CRITERIA_CLASSES.add("java.security.AllPermission");
        CRITERIA_CLASSES.add("java.security.AuthProvider");
        CRITERIA_CLASSES.add("java.security.BasicPermission");
        CRITERIA_CLASSES.add("java.security.CodeSigner");
        CRITERIA_CLASSES.add("java.security.CodeSource");
        CRITERIA_CLASSES.add("java.security.DigestInputStream");
        CRITERIA_CLASSES.add("java.security.DigestOutputStream");
        CRITERIA_CLASSES.add("java.security.DomainLoadStoreParameter");
        CRITERIA_CLASSES.add("java.security.GuardedObject");
        CRITERIA_CLASSES.add("java.security.Identity");
        CRITERIA_CLASSES.add("java.security.IdentityScope");
        CRITERIA_CLASSES.add("java.security.KeyFactory");
        CRITERIA_CLASSES.add("java.security.KeyFactorySpi");
        CRITERIA_CLASSES.add("java.security.KeyPair");
        CRITERIA_CLASSES.add("java.security.KeyPairGeneratorSpi");
        CRITERIA_CLASSES.add("java.security.KeyRep");
        CRITERIA_CLASSES.add("java.security.KeyStore$Builder");
        CRITERIA_CLASSES.add("java.security.KeyStore$CallbackHandlerProtection");
        CRITERIA_CLASSES.add("java.security.KeyStore$PasswordProtection");
        CRITERIA_CLASSES.add("java.security.KeyStore$PrivateKeyEntry");
        CRITERIA_CLASSES.add("java.security.KeyStore$SecretKeyEntry");
        CRITERIA_CLASSES.add("java.security.KeyStore$TrustedCertificateEntry");
        CRITERIA_CLASSES.add("java.security.KeyStoreSpi");
        CRITERIA_CLASSES.add("java.security.MessageDigestSpi");
        CRITERIA_CLASSES.add("java.security.Permission");
        CRITERIA_CLASSES.add("java.security.PermissionCollection");
        CRITERIA_CLASSES.add("java.security.Permissions");
        CRITERIA_CLASSES.add("java.security.PKCS12Attribute");
        CRITERIA_CLASSES.add("java.security.Policy");
        CRITERIA_CLASSES.add("java.security.PolicySpi");
        CRITERIA_CLASSES.add("java.security.ProtectionDomain");
        CRITERIA_CLASSES.add("java.security.Provider");
        CRITERIA_CLASSES.add("java.security.Provider.Service");
        CRITERIA_CLASSES.add("java.security.SecureClassLoader");
        CRITERIA_CLASSES.add("java.security.SecureRandomSpi");
        CRITERIA_CLASSES.add("java.security.Security");
        CRITERIA_CLASSES.add("java.security.SecurityPermission");
        CRITERIA_CLASSES.add("java.security.Signature");
        CRITERIA_CLASSES.add("java.security.SignatureSpi");
        CRITERIA_CLASSES.add("java.security.SignedObject");
        CRITERIA_CLASSES.add("java.security.Signer");
        CRITERIA_CLASSES.add("java.security.Timestamp");
        CRITERIA_CLASSES.add("java.security.UnresolvedPermission");
        CRITERIA_CLASSES.add("java.security.URIParameter");

        CRITERIA_CLASSES.add("java.security.cert.CertPathBuilderResult");
        CRITERIA_CLASSES.add("java.security.cert.CertPathChecker");
        CRITERIA_CLASSES.add("java.security.cert.CertPathParameters");
        CRITERIA_CLASSES.add("java.security.cert.CertPathValidatorException.Reason");
        CRITERIA_CLASSES.add("java.security.cert.CertPathValidatorResult");
        CRITERIA_CLASSES.add("java.security.cert.CertSelector");
        CRITERIA_CLASSES.add("java.security.cert.CertStoreParameters");
        CRITERIA_CLASSES.add("java.security.cert.CRLSelector");
        CRITERIA_CLASSES.add("java.security.cert.Extension");
        CRITERIA_CLASSES.add("java.security.cert.PolicyNode");
        CRITERIA_CLASSES.add("java.security.cert.X509Extension");
        CRITERIA_CLASSES.add("java.security.cert.Certificate");
        CRITERIA_CLASSES.add("java.security.cert.Certificate$CertificateRep");
        CRITERIA_CLASSES.add("java.security.cert.CertificateFactory");
        CRITERIA_CLASSES.add("java.security.cert.CertificateFactorySpi");
        CRITERIA_CLASSES.add("java.security.cert.CertPath");
        CRITERIA_CLASSES.add("java.security.cert.CertPath.CertPathRep");
        CRITERIA_CLASSES.add("java.security.cert.CertPathBuilder");
        CRITERIA_CLASSES.add("java.security.cert.CertPathBuilderSpi");
        CRITERIA_CLASSES.add("java.security.cert.CertPathValidator");
        CRITERIA_CLASSES.add("java.security.cert.CertPathValidatorSpi");
        CRITERIA_CLASSES.add("java.security.cert.CertStore");
        CRITERIA_CLASSES.add("java.security.cert.CertStoreSpi");
        CRITERIA_CLASSES.add("java.security.cert.CollectionCertStoreParameters");
        CRITERIA_CLASSES.add("java.security.cert.CRL");
        CRITERIA_CLASSES.add("java.security.cert.LDAPCertStoreParameters");
        CRITERIA_CLASSES.add("java.security.cert.PKIXBuilderParameters");
        CRITERIA_CLASSES.add("java.security.cert.PKIXCertPathBuilderResult");
        CRITERIA_CLASSES.add("java.security.cert.PKIXCertPathChecker");
        CRITERIA_CLASSES.add("java.security.cert.PKIXCertPathValidatorResult");
        CRITERIA_CLASSES.add("java.security.cert.PKIXParameters");
        CRITERIA_CLASSES.add("java.security.cert.PKIXRevocationChecker");
        CRITERIA_CLASSES.add("java.security.cert.PolicyQualifierInfo");
        CRITERIA_CLASSES.add("java.security.cert.TrustAnchor");
        CRITERIA_CLASSES.add("java.security.cert.X509Certificate");
        CRITERIA_CLASSES.add("java.security.cert.X509CertSelector");
        CRITERIA_CLASSES.add("java.security.cert.X509CRL");
        CRITERIA_CLASSES.add("java.security.cert.X509CRLEntry");
        CRITERIA_CLASSES.add("java.security.cert.X509CRLSelector");

        CRITERIA_CLASSES.add("java.security.spec.AlgorithmParameterSpec");
        CRITERIA_CLASSES.add("java.security.spec.ECField");
        CRITERIA_CLASSES.add("java.security.spec.KeySpec");
        CRITERIA_CLASSES.add("java.security.spec.DSAGenParameterSpec");
        CRITERIA_CLASSES.add("java.security.spec.DSAParameterSpec");
        CRITERIA_CLASSES.add("java.security.spec.DSAPrivateKeySpec");
        CRITERIA_CLASSES.add("java.security.spec.DSAPublicKeySpec");
        CRITERIA_CLASSES.add("java.security.spec.ECFieldF2m");
        CRITERIA_CLASSES.add("java.security.spec.ECFieldFp");
        CRITERIA_CLASSES.add("java.security.spec.ECGenParameterSpec");
        CRITERIA_CLASSES.add("java.security.spec.ECParameterSpec");
        CRITERIA_CLASSES.add("java.security.spec.ECPoint");
        CRITERIA_CLASSES.add("java.security.spec.ECPrivateKeySpec");
        CRITERIA_CLASSES.add("java.security.spec.ECPublicKeySpec");
        CRITERIA_CLASSES.add("java.security.spec.EllipticCurve");
        CRITERIA_CLASSES.add("java.security.spec.EncodedKeySpec");
        CRITERIA_CLASSES.add("java.security.spec.MGF1ParameterSpec");
        CRITERIA_CLASSES.add("java.security.spec.PKCS8EncodedKeySpec");
        CRITERIA_CLASSES.add("java.security.spec.PSSParameterSpec");
        CRITERIA_CLASSES.add("java.security.spec.RSAKeyGenParameterSpec");
        CRITERIA_CLASSES.add("java.security.spec.RSAMultiPrimePrivateCrtKeySpec");
        CRITERIA_CLASSES.add("java.security.spec.RSAOtherPrimeInfo");
        CRITERIA_CLASSES.add("java.security.spec.RSAPrivateCrtKeySpec");
        CRITERIA_CLASSES.add("java.security.spec.RSAPrivateKeySpec");
        CRITERIA_CLASSES.add("java.security.spec.RSAPublicKeySpec");
        CRITERIA_CLASSES.add("java.security.spec.X509EncodedKeySpec");

        CRITERIA_CLASSES.add("javax.crypto.spec.DESedeKeySpec");
        CRITERIA_CLASSES.add("javax.crypto.spec.DESKeySpec");
        CRITERIA_CLASSES.add("javax.crypto.spec.DHGenParameterSpec");
        CRITERIA_CLASSES.add("javax.crypto.spec.DHParameterSpec");
        CRITERIA_CLASSES.add("javax.crypto.spec.DHPrivateKeySpec");
        CRITERIA_CLASSES.add("javax.crypto.spec.DHPublicKeySpec");
        CRITERIA_CLASSES.add("javax.crypto.spec.GCMParameterSpec");
        CRITERIA_CLASSES.add("javax.crypto.spec.OAEPParameterSpec");
        CRITERIA_CLASSES.add("javax.crypto.spec.PSource");
        CRITERIA_CLASSES.add("javax.crypto.spec.PSource$PSpecified");
        CRITERIA_CLASSES.add("javax.crypto.spec.RC2ParameterSpec");
        CRITERIA_CLASSES.add("javax.crypto.spec.RC5ParameterSpec");


        CRITERIA_CLASSES.add("javax.crypto.interfaces.DHKey");
        CRITERIA_CLASSES.add("javax.crypto.interfaces.DHPrivateKey");
        CRITERIA_CLASSES.add("javax.crypto.interfaces.DHPublicKey");
        CRITERIA_CLASSES.add("javax.crypto.interfaces.PBEKey");

        CRITERIA_CLASSES.add("java.security.interfaces.DSAKey");
        CRITERIA_CLASSES.add("java.security.interfaces.DSAKeyPairGenerator");
        CRITERIA_CLASSES.add("java.security.interfaces.DSAParams");
        CRITERIA_CLASSES.add("java.security.interfaces.DSAPrivateKey");
        CRITERIA_CLASSES.add("java.security.interfaces.DSAPublicKey");
        CRITERIA_CLASSES.add("java.security.interfaces.ECKey");
        CRITERIA_CLASSES.add("java.security.interfaces.ECPrivateKey");
        CRITERIA_CLASSES.add("java.security.interfaces.ECPublicKey");
        CRITERIA_CLASSES.add("java.security.interfaces.RSAKey");
        CRITERIA_CLASSES.add("java.security.interfaces.RSAMultiPrimePrivateCrtKey");
        CRITERIA_CLASSES.add("java.security.interfaces.RSAPrivateCrtKey");
        CRITERIA_CLASSES.add("java.security.interfaces.RSAPrivateKey");
        CRITERIA_CLASSES.add("java.security.interfaces.RSAPublicKey");



        CRITERIA_CLASSES.add("javax.crypto.Cipher");
        CRITERIA_CLASSES.add("java.security.MessageDigest");
        CRITERIA_CLASSES.add("javax.crypto.spec.SecretKeySpec");
        CRITERIA_CLASSES.add("javax.crypto.spec.PBEKeySpec");
        CRITERIA_CLASSES.add("java.security.KeyPairGenerator");
        CRITERIA_CLASSES.add("java.net.URL");
        CRITERIA_CLASSES.add("okhttp3.Request$Builder");
        CRITERIA_CLASSES.add("retrofit2.Retrofit$Builder");
        CRITERIA_CLASSES.add("javax.crypto.spec.PBEParameterSpec");
        CRITERIA_CLASSES.add("javax.crypto.spec.IvParameterSpec");
        CRITERIA_CLASSES.add("java.security.KeyStore");
        CRITERIA_CLASSES.add("java.security.SecureRandom");
    }

    public static Set<SootMethod> setCriteria(List<String> classNames){

        Set<SootMethod> cryptoAPI = new HashSet<SootMethod>();
        for(String className:classNames) {
            SootClass sClass = Scene.v().loadClassAndSupport(className);
            Iterator methodIt = sClass.getMethods().iterator();
            while (methodIt.hasNext()) {
                SootMethod m = (SootMethod) methodIt.next();
                MethodWrapper caller = NamedMethodMap.getMethod(m.toString());
                List<MethodCallSiteInfo> calleeList = caller.getCalleeList();
                for (MethodCallSiteInfo methodCallSiteInfo : calleeList) {
                    SootMethod sMethod = methodCallSiteInfo.getCallee().getMethod();
                    String packageName = sMethod.getDeclaringClass().toString();
                    if (packageName.contains("java.security") || packageName.contains("javax.crypto") || packageName.contains("javax.net.ssl")) {


                        cryptoAPI.add(sMethod);
                    }
                }


            }
        }
        return cryptoAPI;

    }
    public static void addCriteria(Set<SootMethod> cryptoAPIs){
        for(SootMethod sMethod: cryptoAPIs){
            String method = sMethod.toString();
            String clazzName = sMethod.getDeclaringClass().toString();
            String methodName = method.substring(method.indexOf(":")+2,method.length()-1);
            int argSize = sMethod.getParameterCount();
            boolean isStatic = sMethod.isStatic();
            if(isStatic){   //Static method, cannot use the object as the criterion
                if(argSize>0) {
                    Criteria criteria = new Criteria();
                    criteria.setClassName(clazzName);
                    criteria.setMethodName(methodName);
                    CRITERIA_LIST.add(criteria);
                }

                else{
                    System.err.println("Found static method without augment:");
                    System.err.println(sMethod.toString());
                }
            }
            else{   //dynamic method, there is an object which can be used as a criterion
                Criteria criteria = new Criteria();
                criteria.setClassName(clazzName);
                criteria.setMethodName(methodName);
                CRITERIA_LIST.add(criteria);

            }

        }

        System.out.println("Dynamic load "+CRITERIA_LIST.size()+" criteria in list.");

    }

    private static void FindEntryPoints(MethodWrapper criteria,
                                        Integer slicingParam) throws IOException {


        List<MethodWrapper> callers = criteria.getCallerList();

        if (callers.isEmpty() ) {
            System.out.println("No callsite for criteria found.");
            return;

        }
        Set<MethodCallSiteInfo> callSites = new HashSet<>();

        for(MethodWrapper caller : callers) {
            for (MethodCallSiteInfo site: caller.getCalleeList()) {
                if (site.getCallee().toString().equals(criteria.toString())) {
                    callSites.add(site);

                }
            }
        }
if(debug_flag) {
    System.out.println("Find " + callSites.size() + " callsite for slicing criterion" + criteria);
    for(MethodCallSiteInfo callSite: callSites){
        System.out.println(callSite);
        if(callSite.getCaller().getMethod().toString().equals("<com.parse.signpost.signature.HmacSha1MessageSigner: java.lang.String sign(com.parse.signpost.http.HttpRequest,com.parse.signpost.http.HttpParameters)>")){
            SootMethod cMethod = callSite.getCaller().getMethod();
            Body checkedMethod = cMethod.getActiveBody();
            UnitGraph c_graph = new ExceptionalUnitGraph(checkedMethod);
            Iterator unitIt = c_graph.iterator();
            while(unitIt.hasNext()){
                Unit c_u = (Unit) unitIt.next();
                System.out.println(c_u);
            }



        }
    }
}


        for (MethodCallSiteInfo callSite: callSites) {
            sliceCount=0;
            realSliceCount = 0;
            Set<Integer> params = new HashSet<Integer>();
            params.add(slicingParam);
            //add all usage
            SootMethod criteriaMethod = callSite.getCallee().getMethod();
            if(!criteriaMethod.isStatic()){
                params.add(-1);
            }
            int nArg = criteriaMethod.getParameterCount();
            for (int i=0; i<nArg;i++){
                params.add(i);
            }




            SlicingCriteria slicingCriteria = new SlicingCriteria(callSite, params);


            ResultInMethod resultInMethod;
            //if(!analysisResult.containsKey(callSite.getCaller().getMethod())){
                if(debug_flag){
                    System.out.println("Backward Slicing for slicingCriteria: "+slicingCriteria);
                    System.out.println("First traverse for method: "+callSite.getCaller().getMethod().toString());
                }
                resultInMethod = new ResultInMethod(callSite.getCaller().getMethod());
                analysisResult.put(callSite.getCaller().getMethod(),resultInMethod);
                resultInMethod.creatSliceForCriteria(slicingCriteria);
            Slice newSlice = resultInMethod.getSliceByCriteria(slicingCriteria);
          //  }
          /*  else{
                if(debug_flag){
                    System.out.println("Backward Slicing for slicingCriteria: "+slicingCriteria);

                }
                resultInMethod = analysisResult.get(callSite.getCaller().getMethod());
                if(!resultInMethod.hasSliceforCriteria(slicingCriteria)){
                    if(debug_flag){
                        System.out.println("Create slice for this slicingCriteria");

                    }
                    resultInMethod.creatSliceForCriteria(slicingCriteria);
                }
                else{
                    // Has already slicing for this criteria.

                    //Notice where to parse entire analysis result.
                    //summarize result here.
                    if(debug_flag){
                        System.out.println("Already has slice for slicingCriteria: "+slicingCriteria);
                        System.out.println("Skip");
                    }
                    return;
                }
            }*/

            currentBeginningCriteria = slicingCriteria;
            Stack<MethodCallSiteInfo> callerRecord = new Stack<MethodCallSiteInfo>();
            callerRecord.push(callSite);
            BackwardSlicer bSlicer = new BackwardSlicer(slicingCriteria,0,newSlice,callerRecord);

            Slice slice = analysisResult.get(callSite.getCaller().getMethod()).getSliceByCriteria(slicingCriteria);

           Stack<List<Pair<String,String>>> unitTrace = new Stack<>();
           Stack<SlicingCriteria> callerStack = new Stack<>();
           callerStack.push(slicingCriteria);
            slice.writeCompleteTraces(unitTrace,callerStack);
            //log.info("For slicing criteria "+slicingCriteria+" total slices: "+realSliceCount);


            System.gc();
            System.gc();


        }





    }


    public static void main(String[] args) throws IOException {
        try {
            writer = new BufferedWriter(new FileWriter("Slice.txt", true));
            FileHandler fh = new FileHandler("./CryptoSlicerLogger.log");
            log.addHandler(fh);

        } catch (IOException e) {
            e.printStackTrace();
        }
        String projectApkPath=args[0];
        writer.write("Analyzing "+projectApkPath+"===================\n");

        log.info("Analyzing "+projectApkPath+":");
        String javaHome = System.getenv("JAVA_HOME");
        String androidHome = System.getenv("ANDROID_SDK_HOME");

        if (javaHome == null) {

            System.err.println("Please set JAVA_HOME");
            System.exit(1);
        }
        if (androidHome == null) {

            System.err.println("Please set ANDROID_SDK_HOME");
            System.exit(1);
        }
        List<String> classNames = Utils.getClassNamesFromApkArchive(projectApkPath);

        Options.v().set_keep_line_number(true);
        Options.v().set_src_prec(Options.src_prec_apk);
        Options.v().set_android_jars(androidHome + "/platforms");
        Options.v().set_soot_classpath(javaHome + "/jre/lib/rt.jar:" + javaHome + "/jre/lib/jce.jar");

        Options.v().set_process_dir(Collections.singletonList(projectApkPath));
        Options.v().set_whole_program(true);
        Options.v().set_allow_phantom_refs(true);

        for (String clazz : CRITERIA_CLASSES) {
            Scene.v().loadClassAndSupport(clazz);
        }

        for (String clazz : classNames) {
            Scene.v().loadClassAndSupport(clazz);
        }
        Scene.v().loadNecessaryClasses();

        CallGraphBuilder callGraphBuilder = new CallGraphBuilder(projectApkPath,classNames);
        callGraphBuilder.buildCallGraph();
        Set<SootMethod> cryptoAPI = setCriteria(classNames);
        addCriteria(cryptoAPI);
        String filename = projectApkPath.substring(projectApkPath.lastIndexOf("/")+1);
        //writing to files



                final ExecutorService service = Executors.newSingleThreadExecutor();

                try {
                    final Future<Object> f = service.submit(() -> {
                        for (Criteria criteria : CRITERIA_LIST) {
                            String endPoint = "<" + criteria.getClassName() + ": " + criteria.getMethodName() + ">";
                            SootClass criteriaClazz = Scene.v().getSootClass(criteria.getClassName());
                            if (criteriaClazz.isPhantomClass() || !criteriaClazz.getMethods().toString().contains(endPoint)) {
                                System.out.println("Skip Criteria:" + criteriaClazz);
                            } else {
                                FindEntryPoints(NamedMethodMap.getMethod(endPoint), criteria.getParam());
                            }
                        }

                        writer.close();
                        if (!analysisResult.isEmpty()) {

                            String dfgFileName = projectApkPath.substring(projectApkPath.lastIndexOf("/") + 1);
                            dfgWriter = new BufferedWriter(new FileWriter(dfgFileName + "_DFG.txt"));
                            dfgWriter.write("Write DFG for APK " + projectApkPath + "\n");
                            for (ResultInMethod resultInMethod : analysisResult.values()) {
                                for (Slice sliceForCriteria : resultInMethod.getSlicesForCriteria()) {
                                    dfgWriter.write("====================DFG for " + sliceForCriteria.getSignature() + "\n");
                                    sliceForCriteria.writeDfg();
                                    sliceForCriteria.getDfg().writeCallerLink();
                                    sliceForCriteria.getDfg().writeCalleeLink();
                                    dfgWriter.write("=============================================================\n");

                                }
                                for (Slice sliceForValue : resultInMethod.getSlicesForValue()) {
                                    dfgWriter.write("======================DFG for " + sliceForValue.getSignature() + "\n");
                                    sliceForValue.writeDfg();
                                    sliceForValue.getDfg().writeCallerLink();
                                    sliceForValue.getDfg().writeCalleeLink();
                                    dfgWriter.write("=============================================================\n");
                                }
                            }
                            dfgWriter.close();
                        }
                        return realSliceCount;
                    });

                    System.out.println(f.get(60000, TimeUnit.SECONDS));
                } catch (final TimeoutException e) {
                    System.err.println("Time out");
                    System.exit(3);
                } catch (final Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    service.shutdown();
                }















    }




}