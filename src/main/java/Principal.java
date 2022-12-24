import Managers.AulaManager;
import Managers.ManagerPrincipal;
import Managers.OrdenadorManager;

public class Principal {
	public static void main(String[] args) {
		
		ManagerPrincipal.setup();
		
		AulaManager manageraula = new AulaManager();
		manageraula.create();
		manageraula.informacion(1);
		
		OrdenadorManager managerordenador=new OrdenadorManager();
		managerordenador.create();
		managerordenador.informacion(1);
		
		ManagerPrincipal.exit();
		
	
	}
}