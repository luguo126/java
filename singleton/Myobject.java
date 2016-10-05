import java.io.ObjectStreamException;
import java.io.Serializable;


class Myobject implements Serializable {
	private static final long serialVersionID = 888L;

	private static class MyobjectHandler {
		private static final Myobject myobject = new Myobject();
	}

	private Myobject() {
		;
	}

	public static Myobject getInstance() {
		return MyobjectHandler.myobject;
	}

	//protected Object readResolve() throws ObjectStreamException {
	//	System.out.println("calls readResolve()");
	//	return MyobjectHandler.myobject;
	//}
}

