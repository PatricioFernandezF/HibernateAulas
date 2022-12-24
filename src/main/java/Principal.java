import Managers.AulaManager;
import Managers.OrdenadorManager;

public class Principal {
	public static void main(String[] args) {
		AulaManager manageraula = new AulaManager();
		manageraula.setup();
		manageraula.create();
		manageraula.informacion(1);
		manageraula.exit();
		
		OrdenadorManager managerordenador=new OrdenadorManager();
		managerordenador.setup();
		managerordenador.create();
		managerordenador.informacion(1);
		managerordenador.exit();
		
	}
}