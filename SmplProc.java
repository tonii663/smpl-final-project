public class SmplProc extends SmplType<ProcClosure>{
    public SmplProc(ProcClosure data) {
        super(data);
    }

   

    @Override
    public String toString() {
      return String.format("<%s> %s", getClass().toString(), getValue().getProc().getName());
    }
}
