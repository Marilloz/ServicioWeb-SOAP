package sos.fi.upm.es;

import java.rmi.RemoteException;
import java.util.Scanner;

import sos.fi.upm.es.UPMGeoCachingStub;
import sos.fi.upm.es.UPMGeoCachingStub.ChangePassword;
import sos.fi.upm.es.UPMGeoCachingStub.Login;
import sos.fi.upm.es.UPMGeoCachingStub.LoginResponse;
import sos.fi.upm.es.UPMGeoCachingStub.PasswordPair;
import sos.fi.upm.es.UPMGeoCachingStub.RemoveUser;
import sos.fi.upm.es.UPMGeoCachingStub.RemoveUserResponse;
import sos.fi.upm.es.UPMGeoCachingStub.Response;
import sos.fi.upm.es.UPMGeoCachingStub.User;
import sos.fi.upm.es.UPMGeoCachingStub.*;

import java.lang.reflect.InvocationTargetException;    
import java.lang.reflect.Method; 


public class PruebaCliente {
	static String userNameBagheera = "Bagheera";
	static String userPwdBagheera = "Bagheera8572";

		
	public static void prueba1() throws RemoteException{

		UPMGeoCachingStub stub = new UPMGeoCachingStub();
		stub._getServiceClient().getOptions().setManageSession(true);
		stub._getServiceClient().engageModule("addressing");

		AddUser user = new AddUser();
		Username u = new Username();
		u.setUsername("Bagheera");
		user.setArgs0(u);
		Login login23 = new Login();
		User param = new User();
		param.setName(userNameBagheera);
		param.setPwd(userPwdBagheera);
		login23.setArgs0(param );
		stub.login(login23);

		AddUserResponseE res = stub.addUser(user);
		AddUserResponse respuesta = res.get_return();
		if(respuesta.getResponse()){
			System.out.println(respuesta.getPwd());
		}
		else{
			System.out.println("USUARIO YA EXISTENTE");
		}


		UPMGeoCachingStub stub2 = new UPMGeoCachingStub();
		stub2._getServiceClient().getOptions().setManageSession(true);
		stub2._getServiceClient().engageModule("addressing");
		stub2.addUser(user);

	}
	public static UPMGeoCachingStub genStub() throws RemoteException{
		UPMGeoCachingStub stub = new UPMGeoCachingStub();
		stub._getServiceClient().getOptions().setManageSession(true);
		stub._getServiceClient().engageModule("addressing");
		return stub;
	}
	
	public static void prueba2()throws RemoteException{
		UPMGeoCachingStub stub = genStub();
		Login login23 = new Login();
		User param = new User();
		param.setName(userNameBagheera);
		param.setPwd(userPwdBagheera);
		login23.setArgs0(param );
		LoginResponse resL =stub.login(login23);
		Response resLogin  = resL.get_return();
		System.out.println("1 " + resLogin.getResponse());
		resL =stub.login(login23);
		resLogin  = resL.get_return();
		System.out.println("2 " + resLogin.getResponse());
		
		
		Login login24 = new Login();
		User param2 = new User();
		param2.setName("nombreRandom");
		param2.setPwd(userPwdBagheera);
		login24.setArgs0(param2);
		resL =stub.login(login24);
		resLogin  = resL.get_return();
		System.out.println("3 " + resLogin.getResponse());
	
		
		UPMGeoCachingStub stub2 = genStub();
		Login login25 = new Login();
		User param3 = new User();
		param3.setName("admin");
		param3.setPwd("admin");
		login25.setArgs0(param3);
		resL =stub2.login(login25);
		resLogin  = resL.get_return();
		System.out.println("4 " + resLogin.getResponse());
		
	}
	
	public static void prueba3() throws RemoteException{
		UPMGeoCachingStub stub = genStub();
		Login login23 = new Login();
		User param = new User();
		param.setName("admin");
		param.setPwd("admin");
		login23.setArgs0(param );
		LoginResponse resL =stub.login(login23);
		Response resLogin  = resL.get_return();
		System.out.println("1 " + resLogin.getResponse());
		
		AddUser user = new AddUser();
		Username u = new Username();
		u.setUsername("Akela");
		user.setArgs0(u);
		AddUserResponseE res = stub.addUser(user);
		AddUserResponse respuesta = res.get_return();
		String pwd = "";
		if(respuesta.getResponse()){
			pwd = respuesta.getPwd();
			System.out.println(respuesta.getPwd());
		}
		else{
			System.out.println("USUARIO YA EXISTENTE");
		}
		
		UPMGeoCachingStub stub2 = genStub();
		Login login24 = new Login();
		User param2 = new User();
		param2.setName("Akela");
		param2.setPwd(pwd);
		login24.setArgs0(param2);
		resL =stub2.login(login24);
		resLogin  = resL.get_return();
		System.out.println("2 " + resLogin.getResponse());
		
		
		RemoveUser removeUser9 = new RemoveUser();
		removeUser9.setArgs0(u);
		RemoveUserResponse resRv = stub.removeUser(removeUser9 );
		Response resFin = resRv.get_return();
		System.out.println(resFin.getResponse());
	}
	
	public static void prueba4() throws RemoteException{
		UPMGeoCachingStub stub = genStub();
		Login login23 = new Login();
		User param = new User();
		param.setName(userNameBagheera);
		param.setPwd(userPwdBagheera);
		login23.setArgs0(param );
		LoginResponse resL =stub.login(login23);
		Response resLogin  = resL.get_return();
		System.out.println("1 " + resLogin.getResponse());
		
		ChangePassword changePassword21 = new ChangePassword();
		PasswordPair param2 = new PasswordPair();
		param2.setNewpwd("Bagheera>Baloo");
		param2.setOldpwd(userPwdBagheera);
		changePassword21.setArgs0(param2 );
		stub.changePassword(changePassword21 );
	}
	
	public static void prueba5() throws RemoteException{
		UPMGeoCachingStub stub = genStub();
		Login login23 = new Login();
		User param = new User();
		param.setName("admin");
		param.setPwd("admin");
		login23.setArgs0(param );
		LoginResponse resL =stub.login(login23);
		Response resLogin  = resL.get_return();
		System.out.println("1 " + resLogin.getResponse());
		
		ChangePassword changePassword21 = new ChangePassword();
		PasswordPair param2 = new PasswordPair();
		param2.setNewpwd("administrador");
		param2.setOldpwd("admin");
		changePassword21.setArgs0(param2 );
		stub.changePassword(changePassword21 );
	
		UPMGeoCachingStub stub2 = genStub();
		 resL =stub.login(login23);
		 resLogin  = resL.get_return();
		System.out.println("2 " + resLogin.getResponse());

	}
	
	public static void add() throws RemoteException{
		UPMGeoCachingStub stub = genStub();
		Login login23 = new Login();
		User param = new User();
		param.setName("admin");
		param.setPwd("admin");
		login23.setArgs0(param );
		LoginResponse resL =stub.login(login23);
		Response resLogin  = resL.get_return();
		System.out.println("1 " + resLogin.getResponse());
		
		Username u = new Username();
		u.setUsername("Bagheera");
		
		RemoveUser removeUser9 = new RemoveUser();
		removeUser9.setArgs0(u);
		RemoveUserResponse resRv = stub.removeUser(removeUser9 );
		Response resFin = resRv.get_return();
		System.out.println(resFin.getResponse());
		
		AddUser user = new AddUser();
		
		user.setArgs0(u);
		
		AddUserResponseE res = stub.addUser(user);
		AddUserResponse respuesta = res.get_return();
		if(respuesta.getResponse()){
			System.out.println(respuesta.getPwd());
		}
		else{
			System.out.println("USUARIO YA EXISTENTE");
		}
		
	}

	static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) throws RemoteException {
		String prueba = "";
		
		boolean fin = true;
		do {
			System.out.println("Introduzca la prueba");
			try {
				prueba = reader.next();

			} catch(Exception e) {
				System.out.println("la prueba");
				reader.next();
			}
			try{
				Method m = PruebaCliente.class.getDeclaredMethod(prueba, null); 
				Object rv = m.invoke(null, null); 
			}catch(Exception e){
				e.printStackTrace();
				fin = false;
			}
		} while(fin);
	}
}
