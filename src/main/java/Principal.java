import Managers.AulaManager;

public class Principal {
	public static void main(String[] args) {
		AulaManager manager = new AulaManager();
		manager.setup();
		manager.create();
		manager.informacion(1);
		manager.exit();
	}
}