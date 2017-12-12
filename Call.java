public class Call {

    public interface CallBack {
   	 void methodToCallBack();
    }

    class Caller {
        public void register(CallBack callback) {
            callback.methodToCallBack();
        }
    }
/*
    public static void main(String[] args) {
        Caller caller = new Caller();
        CallBack callBack = new CallBackImpl();
        caller.register(callBack);
    }*/
}
