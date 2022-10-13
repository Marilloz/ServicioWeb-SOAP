package sos.fi.upm.es;

import java.rmi.RemoteException;

import sos.fi.upm.es.UPMGeoCachingStub.AddFollower;
import sos.fi.upm.es.UPMGeoCachingStub.AddFollowerResponse;
import sos.fi.upm.es.UPMGeoCachingStub.AddUser;
import sos.fi.upm.es.UPMGeoCachingStub.AddUserResponse;
import sos.fi.upm.es.UPMGeoCachingStub.AddUserResponseE;
import sos.fi.upm.es.UPMGeoCachingStub.ChangePassword;
import sos.fi.upm.es.UPMGeoCachingStub.ChangePasswordResponse;
import sos.fi.upm.es.UPMGeoCachingStub.CreateTreasure;
import sos.fi.upm.es.UPMGeoCachingStub.CreateTreasureResponse;
import sos.fi.upm.es.UPMGeoCachingStub.FindTreasure;
import sos.fi.upm.es.UPMGeoCachingStub.FindTreasureResponse;
import sos.fi.upm.es.UPMGeoCachingStub.FollowerList;
import sos.fi.upm.es.UPMGeoCachingStub.GetMyFollowerTreasuresCreated;
import sos.fi.upm.es.UPMGeoCachingStub.GetMyFollowerTreasuresCreatedResponse;
import sos.fi.upm.es.UPMGeoCachingStub.GetMyFollowers;
import sos.fi.upm.es.UPMGeoCachingStub.GetMyFollowersResponse;
import sos.fi.upm.es.UPMGeoCachingStub.GetMyTreasuresCreated;
import sos.fi.upm.es.UPMGeoCachingStub.GetMyTreasuresCreatedResponse;
import sos.fi.upm.es.UPMGeoCachingStub.GetMyTreasuresFound;
import sos.fi.upm.es.UPMGeoCachingStub.GetMyTreasuresFoundResponse;
import sos.fi.upm.es.UPMGeoCachingStub.Login;
import sos.fi.upm.es.UPMGeoCachingStub.LoginResponse;
import sos.fi.upm.es.UPMGeoCachingStub.Logout;
import sos.fi.upm.es.UPMGeoCachingStub.PasswordPair;
import sos.fi.upm.es.UPMGeoCachingStub.RemoveFollower;
import sos.fi.upm.es.UPMGeoCachingStub.RemoveFollowerResponse;
import sos.fi.upm.es.UPMGeoCachingStub.RemoveUser;
import sos.fi.upm.es.UPMGeoCachingStub.RemoveUserResponse;
import sos.fi.upm.es.UPMGeoCachingStub.Response;
import sos.fi.upm.es.UPMGeoCachingStub.Treasure;
import sos.fi.upm.es.UPMGeoCachingStub.TreasureList;
import sos.fi.upm.es.UPMGeoCachingStub.User;
import sos.fi.upm.es.UPMGeoCachingStub.Username;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ClienteGeo {

	static Scanner reader = new Scanner(System.in);

//SI LOS USUARIOS YA ESTAN CREADOS, PRIMERO HAY QUE BORRARLOS USANDO EL ADMIN
	static String LuffyPwd = "Luffy6533";
	static String ZoroPwd = "Zoro2969";
	static String ShanksPwd = "Shanks4432";
	static String AdminPwd = "admin";

	static UPMGeoCachingStub stub;
	
	public static void addUserLuffy() throws RemoteException{
		//ADD Luffy
		AddUser user = new AddUser();
		Username u = new Username();
		u.setUsername("Luffy");
		user.setArgs0(u);
		AddUserResponseE res = stub.addUser(user);
		AddUserResponse respuesta = res.get_return();
		if(respuesta.getResponse()){
			LuffyPwd = respuesta.getPwd();
			System.out.println("Contraseña de Luffy: " +respuesta.getPwd());
		}
		else{
			System.out.println("AddUser Error Usuario ya existente o no eres el admin");
		}	
	}

	public static void addUserZoro() throws RemoteException{		
		//ADD Zoro
		AddUser user = new AddUser();
		Username u = new Username();
		u.setUsername("Zoro");
		user.setArgs0(u);
		AddUserResponseE res = stub.addUser(user);
		AddUserResponse respuesta = res.get_return();
		if(respuesta.getResponse()){
			ZoroPwd = respuesta.getPwd();
			System.out.println("Contraseña de Zoro: " +respuesta.getPwd());
		}
		else{
			System.out.println("AddUser Error Usuario ya existente o no eres el admin");
		}		
	}

	public static void addUserShanks() throws RemoteException{		
		//ADD Shanks
		AddUser user = new AddUser();
		Username u = new Username();
		u.setUsername("Shanks");
		user.setArgs0(u);
		AddUserResponseE res = stub.addUser(user);
		AddUserResponse respuesta = res.get_return();
		if(respuesta.getResponse()){
			ShanksPwd = respuesta.getPwd();
			System.out.println("Contraseña de Shanks: " +respuesta.getPwd());
		}
		else{
			System.out.println("AddUser Error Usuario ya existente o no eres el admin");
		}	
	}

	public static void loginAdmin()throws RemoteException{
		Login login23 = new Login();
		User param = new User();
		param.setName("admin");
		param.setPwd(AdminPwd);
		login23.setArgs0(param );
		LoginResponse resL = stub.login(login23);
		Response res2 = resL.get_return();
		System.out.println("Resultado de Login de Admin: "+res2.getResponse());
	}

	public static void loginLuffy()throws RemoteException{
		Login login23 = new Login();
		User param = new User();
		param.setName("Luffy");
		param.setPwd(LuffyPwd);
		login23.setArgs0(param );
		LoginResponse resL = stub.login(login23);
		Response res2 = resL.get_return();
		System.out.println("Resultado de Login de Luffy: "+res2.getResponse());
	}

	public static void loginZoro()throws RemoteException{
		Login login23 = new Login();
		User param = new User();
		param.setName("Zoro");
		param.setPwd(ZoroPwd);
		login23.setArgs0(param );
		LoginResponse resL = stub.login(login23);
		Response res2 = resL.get_return();
		System.out.println("Resultado de Login de Zoro: "+res2.getResponse());
	}

	public static void loginShanks()throws RemoteException{
		Login login23 = new Login();
		User param = new User();
		param.setName("Shanks");
		param.setPwd(ShanksPwd);
		login23.setArgs0(param );
		LoginResponse resL = stub.login(login23);
		Response res2 = resL.get_return();
		System.out.println("Resultado de Login de Shanks: "+res2.getResponse());
	}

	public static void logout()throws RemoteException{
		Logout logout0 = new Logout();
		stub.logout(logout0 );
	}

	public static void removeUserLuffy() throws RemoteException{
		RemoveUser removeUser9 = new RemoveUser();
		Username u = new Username();
		u.setUsername("Luffy");
		removeUser9.setArgs0(u);
		RemoveUserResponse resRv = stub.removeUser(removeUser9);
		Response resFin = resRv.get_return();
		System.out.println("Resultado de remove Luffy: "+resFin.getResponse());
	}

	public static void removeUserZoro() throws RemoteException{
		RemoveUser removeUser9 = new RemoveUser();
		Username u = new Username();
		u.setUsername("Zoro");
		removeUser9.setArgs0(u);
		RemoveUserResponse resRv = stub.removeUser(removeUser9);
		Response resFin = resRv.get_return();
		System.out.println("Resultado de remove Zoro: "+resFin.getResponse());
	}

	public static void removeUserShanks() throws RemoteException{
		RemoveUser removeUser9 = new RemoveUser();
		Username u = new Username();
		u.setUsername("Shanks");
		removeUser9.setArgs0(u);
		RemoveUserResponse resRv = stub.removeUser(removeUser9);
		Response resFin = resRv.get_return();
		System.out.println("Resultado de remove Shanks: "+resFin.getResponse());
	}

	public static void changePasswordLuffy() throws RemoteException{
		ChangePassword changePassword21 = new ChangePassword();
		PasswordPair param2 = new PasswordPair();
		param2.setNewpwd("Luffy>Shanks");
		param2.setOldpwd(LuffyPwd);
		changePassword21.setArgs0(param2 );
		ChangePasswordResponse resCP = stub.changePassword(changePassword21 );
		Response resCP2 = resCP.get_return();
		System.out.println("Resultado de ChangePassword Luffy: "+ resCP2.getResponse());
		if(resCP2.getResponse()){
			LuffyPwd = "Luffy>Shanks";
		}
	}

	public static void changePasswordZoro() throws RemoteException{
		ChangePassword changePassword21 = new ChangePassword();
		PasswordPair param2 = new PasswordPair();
		param2.setNewpwd("Luffy>Shanks");
		param2.setOldpwd(ZoroPwd);
		changePassword21.setArgs0(param2 );
		ChangePasswordResponse resCP = stub.changePassword(changePassword21 );
		Response resCP2 = resCP.get_return();
		System.out.println("Resultado de ChangePassword Zoro: "+ resCP2.getResponse());
		if(resCP2.getResponse()){
			ZoroPwd = "Luffy>Shanks";
		}
	}

	public static void changePasswordShanks() throws RemoteException{
		ChangePassword changePassword21 = new ChangePassword();
		PasswordPair param2 = new PasswordPair();
		param2.setNewpwd("Luffy>Shanks");
		param2.setOldpwd(ShanksPwd);
		changePassword21.setArgs0(param2 );
		ChangePasswordResponse resCP = stub.changePassword(changePassword21 );
		Response resCP2 = resCP.get_return();
		System.out.println("Resultado de ChangePassword Shanks: "+ resCP2.getResponse());
		if(resCP2.getResponse()){
			ShanksPwd = "Luffy>Shanks";
		}
	}

	public static void addFollowerLuffy() throws RemoteException{
		AddFollower addFollower11 = new AddFollower();
		Username parametro1 = new Username();
		parametro1.setUsername("Luffy");
		addFollower11.setArgs0(parametro1);
		AddFollowerResponse resAF = stub.addFollower(addFollower11);
		Response res = resAF.get_return();
		System.out.println("Resultado de addFollower Luffy: "+res.getResponse());
	}

	public static void addFollowerZoro() throws RemoteException{
		AddFollower addFollower11 = new AddFollower();
		Username parametro1 = new Username();
		parametro1.setUsername("Zoro");
		addFollower11.setArgs0(parametro1);
		AddFollowerResponse resAF = stub.addFollower(addFollower11);
		Response res = resAF.get_return();
		System.out.println("Resultado de addFollower Zoro: "+res.getResponse());
	}

	public static void addFollowerShanks() throws RemoteException{
		AddFollower addFollower11 = new AddFollower();
		Username parametro1 = new Username();
		parametro1.setUsername("Shanks");
		addFollower11.setArgs0(parametro1);
		AddFollowerResponse resAF = stub.addFollower(addFollower11);
		Response res = resAF.get_return();
		System.out.println("Resultado de addFollower Shanks: "+res.getResponse());
	}

	public static void removeFollowerLuffy() throws RemoteException{
		RemoveFollower removeFollower1;
		Username parametro1 = new Username();
		parametro1.setUsername("Luffy");
		removeFollower1 = new RemoveFollower();
		removeFollower1.setArgs0(parametro1);
		RemoveFollowerResponse resRF = stub.removeFollower(removeFollower1);
		Response res = resRF.get_return();
		System.out.println("Resultado de removeFollower Luffy: "+res.getResponse());
	}

	public static void removeFollowerZoro() throws RemoteException{
		RemoveFollower removeFollower1;
		Username parametro1 = new Username();
		parametro1.setUsername("Zoro");
		removeFollower1 = new RemoveFollower();
		removeFollower1.setArgs0(parametro1);
		RemoveFollowerResponse resRF = stub.removeFollower(removeFollower1);
		Response res = resRF.get_return();
		System.out.println("Resultado de removeFollower Zoro: "+res.getResponse());
	}

	public static void removeFollowerShanks() throws RemoteException{
		RemoveFollower removeFollower1;
		Username parametro1 = new Username();
		parametro1.setUsername("Shanks");
		removeFollower1 = new RemoveFollower();
		removeFollower1.setArgs0(parametro1);
		RemoveFollowerResponse resRF = stub.removeFollower(removeFollower1);
		Response res = resRF.get_return();
		System.out.println("Resultado de removeFollower Shanks: "+res.getResponse());
	}
	
	public static void getMyFollowers() throws RemoteException{
		GetMyFollowers getMyFollowers5 = new GetMyFollowers();
		GetMyFollowersResponse resGF = stub.getMyFollowers(getMyFollowers5);
		FollowerList res = resGF.get_return();
		boolean resBool = res.getResult();
		if(resBool){
			System.out.println("Resultado de getMyFollowers: true");
			System.out.println("Following: "+ Arrays.toString(res.getFollowers()));
			System.out.println("Cantidad de Seguidores = " + res.getFollowers().length);
		}
		else{
			System.out.println("Resultado de getMyFollowers: false");
		}
	}
	
	public static void createTreasureOnePiece() throws RemoteException{
		CreateTreasure createTreasure13 = new CreateTreasure();
		Treasure param = new Treasure();
		param.setName("One Piece");
		param.setAltitude(77);
		param.setLatitude(77);
		createTreasure13.setArgs0(param );
		CreateTreasureResponse resCT = stub.createTreasure(createTreasure13 );
		Response res = resCT.get_return();
		System.out.println("Resultado de createTreasure OnePiece: "+res.getResponse());
	}
	
	public static void createTreasureHitoHitoNikaModel() throws RemoteException{
		CreateTreasure createTreasure13 = new CreateTreasure();
		Treasure param = new Treasure();
		param.setName("Hito Hito no mi: Nika Model");
		param.setAltitude(100);
		param.setLatitude(50);
		createTreasure13.setArgs0(param );
		CreateTreasureResponse resCT = stub.createTreasure(createTreasure13 );
		Response res = resCT.get_return();
		System.out.println("Resultado de createTreasure HitoHitoNikaModel: "+res.getResponse());
	}
	
	public static void createTreasureTumbaDeShirohige() throws RemoteException{
		CreateTreasure createTreasure13 = new CreateTreasure();
		Treasure param = new Treasure();
		param.setName("Tumba De Shirohige");
		param.setAltitude(24);
		param.setLatitude(42);
		createTreasure13.setArgs0(param );
		CreateTreasureResponse resCT = stub.createTreasure(createTreasure13 );
		Response res = resCT.get_return();
		System.out.println("Resultado de createTreasure TumbaDeShirohige: "+res.getResponse());
	}
	
	public static void findTreasureOnePiece() throws RemoteException{
		FindTreasure finTreasure = new FindTreasure();
		Treasure param = new Treasure();
		param.setName("One Piece");
		param.setAltitude(77);
		param.setLatitude(77);
		finTreasure.setArgs0(param);
		FindTreasureResponse resCT = stub.findTreasure(finTreasure);
		Response res = resCT.get_return();
		System.out.println("Resultado de findTreasure OnePiece: "+res.getResponse());
	}
	
	public static void findTreasureHitoHitoNikaModel() throws RemoteException{
		FindTreasure finTreasure = new FindTreasure();
		Treasure param = new Treasure();
		param.setName("Hito Hito no mi: Nika Model");
		param.setAltitude(100);
		param.setLatitude(50);
		finTreasure.setArgs0(param);
		FindTreasureResponse resCT = stub.findTreasure(finTreasure);
		Response res = resCT.get_return();
		System.out.println("Resultado de findTreasure HitoHitoNikaModel: "+res.getResponse());
	}
	
	public static void findTreasureTumbaDeShirohige() throws RemoteException{
		FindTreasure finTreasure = new FindTreasure();
		Treasure param = new Treasure();
		param.setName("Tumba De Shirohige");
		param.setAltitude(24);
		param.setLatitude(42);
		finTreasure.setArgs0(param);
		FindTreasureResponse resCT = stub.findTreasure(finTreasure);
		Response res = resCT.get_return();
		System.out.println("Resultado de findTreasure TumbaDeShirohige: "+res.getResponse());
	}
	
	public static void getMyTreasuresFound() throws RemoteException{
		
		GetMyTreasuresFound getMyTreasuresFound3 = new GetMyTreasuresFound();
		GetMyTreasuresFoundResponse resGTF = stub.getMyTreasuresFound(getMyTreasuresFound3 );
		TreasureList res = resGTF.get_return();
		if(res.getResult()){
			
			System.out.println("Resultado de getMyTreasuresCreated: true");
			System.out.println("Nombres de los Tesoros = " + Arrays.toString(res.getNames()));
			System.out.println("Latitudes de los Tesoros = "+ Arrays.toString(res.getLats()));
			System.out.println("Altitudes de los Tesoros = "+ Arrays.toString(res.getAlts()));
		}
		else{
			System.out.println("Resultado de getMyTreasuresFound: false");

		}
	}

	
	public static void getMyTreasuresCreated() throws RemoteException{
		
		GetMyTreasuresCreated getMyTreasuresCreated7 = new GetMyTreasuresCreated();
		
		GetMyTreasuresCreatedResponse resGTC = stub.getMyTreasuresCreated(getMyTreasuresCreated7);
		TreasureList res = resGTC.get_return();
		if(res.getResult()){
			
			System.out.println("Resultado de getMyTreasuresCreated: true");
			System.out.println("Nombres de los Tesoros = " + Arrays.toString(res.getNames()));
			System.out.println("Latitudes de los Tesoros = "+ Arrays.toString(res.getLats()));
			System.out.println("Altitudes de los Tesoros = "+ Arrays.toString(res.getAlts()));
		}
		else{
			System.out.println("Resultado de getMyTreasuresCreated: false");

		}
	}
	
	public static void getMyFollowerTreasuresCreatedLuffy() throws RemoteException{
		GetMyFollowerTreasuresCreated getMyFollowerTreasuresCreated19 = new GetMyFollowerTreasuresCreated();
		Username param = new Username();
		param.setUsername("Luffy");
		getMyFollowerTreasuresCreated19.setArgs0(param );
		GetMyFollowerTreasuresCreatedResponse resGFTC 
			= stub.getMyFollowerTreasuresCreated(getMyFollowerTreasuresCreated19 );
		TreasureList res = resGFTC.get_return();
		if(res.getResult()){
			System.out.println("Resultado de getMyFollowerTreasuresCreated Luffy: true");
			System.out.println("Nombres de los Tesoros = " + Arrays.toString(res.getNames()));
			System.out.println("Latitudes de los Tesoros = "+ Arrays.toString(res.getLats()));
			System.out.println("Altitudes de los Tesoros = "+ Arrays.toString(res.getAlts()));
		}
		else{
			System.out.println("Resultado de getMyFollowerTreasuresCreated Luffy: false");

		}
	}
	
	public static void getMyFollowerTreasuresCreatedZoro() throws RemoteException{
		System.out.println("ZOROOOOOOOOOoo");
		GetMyFollowerTreasuresCreated getMyFollowerTreasuresCreated19 = new GetMyFollowerTreasuresCreated();
		Username param = new Username();
		param.setUsername("Zoro");
		getMyFollowerTreasuresCreated19.setArgs0(param );
		GetMyFollowerTreasuresCreatedResponse resGFTC 
			= stub.getMyFollowerTreasuresCreated(getMyFollowerTreasuresCreated19 );
		TreasureList res = resGFTC.get_return();
		if(res.getResult()){
			System.out.println("Resultado de getMyFollowerTreasuresCreated Zoro: true");
			System.out.println("Nombres de los Tesoros = " + Arrays.toString(res.getNames()));
			System.out.println("Latitudes de los Tesoros = "+ Arrays.toString(res.getLats()));
			System.out.println("Altitudes de los Tesoros = "+ Arrays.toString(res.getAlts()));
		}
		else{
			System.out.println("Resultado de getMyFollowerTreasuresCreated Zoro: false");

		}
	}
	
	public static void getMyFollowerTreasuresCreatedShanks() throws RemoteException{
		GetMyFollowerTreasuresCreated getMyFollowerTreasuresCreated19 = new GetMyFollowerTreasuresCreated();
		Username param = new Username();
		param.setUsername("Shanks");
		getMyFollowerTreasuresCreated19.setArgs0(param );
		GetMyFollowerTreasuresCreatedResponse resGFTC 
			= stub.getMyFollowerTreasuresCreated(getMyFollowerTreasuresCreated19 );
		TreasureList res = resGFTC.get_return();
		if(res.getResult()){
			System.out.println("Resultado de getMyFollowerTreasuresCreated Shanks: true");
			System.out.println("Nombres de los Tesoros = " + Arrays.toString(res.getNames()));
			System.out.println("Latitudes de los Tesoros = "+ Arrays.toString(res.getLats()));
			System.out.println("Altitudes de los Tesoros = "+ Arrays.toString(res.getAlts()));
		}
		else{
			System.out.println("Resultado de getMyFollowerTreasuresCreated Shanks: false");
		}
	}
	
	static String[] operaciones = {"addUser","login","logout","removeUser","changePassword","addFollower","removeFollower","getMyFollowers","createTreasure","findTreasure","getMyTreasuresFound","getMyTreasuresCreated","getMyFollowerTreasuresCreated","Salir"};
	
	static String[] usuarios = {"Monkey D Luffy","Roronoa Zoro","Shanks","Admin (solo valido para logIn)"};
	
	static String[] tesoros = {"One Piece","Hito Hito no mi: Nika Model","Tumba De Shirohige"};
	
	private static void imprimirLista() {
		System.out.println("Operaciones:");
		for(int i=0;i<operaciones.length;i++) {
			System.out.println(" "+(i+1)+"-"+operaciones[i]);
		}
		System.out.println("");
		System.out.println("Usuarios:");
		for(int i=0;i<usuarios.length;i++) {
			if(i<3)
				System.out.println(" "+(i+1)+"-"+usuarios[i]+"/"+ tesoros[i]);
			else
				System.out.println(" "+(i+1)+"-"+usuarios[i]);
		}
		
	}
	
	public static void main(String[] args) throws RemoteException{
		// TODO Auto-generated method stub
		int numero = 0;
		int numero2 = 0;
		stub = new UPMGeoCachingStub();
		stub._getServiceClient().getOptions().setManageSession(true);
		stub._getServiceClient().engageModule("addressing");
		do {
			System.out.println("Introduzca un numero para elegir la operación, 0 para ver la lista y un numero elegir el Usuario/Tesoro que se enviará como parametro");
			try {
				numero = reader.nextInt();
				numero2 = reader.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("Error al introducir un numero por favor introduzcalo de nuevo");
				reader.next();
			}
			if(numero <= operaciones.length && numero>0)
				System.out.println("Operacion elegida: "+operaciones[numero-1]);
			if(numero2 <= usuarios.length 
					&& numero2>0 && numero != 3 && numero != 8 
					&& numero != 11 && numero != 12 && numero != 14)
				System.out.println("Usuario elegido: "+usuarios[numero2-1]);
			
						
			if(numero == 0)
				imprimirLista();
			else if(numero == 1 && numero2 == 1)
				addUserLuffy();
			else if(numero == 1 && numero2 == 2)
				addUserZoro();
			else if(numero == 1 && numero2 == 3)
				addUserShanks();
			
			else if(numero == 2 && numero2 == 1)
				loginLuffy();
			else if(numero == 2 && numero2 == 2)
				loginZoro();
			else if(numero == 2 && numero2 == 3)
				loginShanks();
			else if(numero == 2 && numero2 == 4)
				loginAdmin();
			
			else if(numero == 3)
				logout();
			
			else if(numero == 4 && numero2 == 1)
				removeUserLuffy();
			else if(numero == 4 && numero2 == 2)
				removeUserZoro();
			else if(numero == 4 && numero2 == 3)
				removeUserShanks();
			
			else if(numero == 5 && numero2 == 1)
				changePasswordLuffy();
			else if(numero == 5 && numero2 == 2)
				changePasswordZoro();
			else if(numero == 5 && numero2 == 3)
				changePasswordShanks();
			
			else if(numero == 6 && numero2 == 1)
				addFollowerLuffy();
			else if(numero == 6 && numero2 == 2)
				addFollowerZoro();
			else if(numero == 6 && numero2 == 3)
				addFollowerShanks();
			
			else if(numero == 7 && numero2 == 1)
				removeFollowerLuffy();
			else if(numero == 7 && numero2 == 2)
				removeFollowerZoro();
			else if(numero == 7 && numero2 == 3)
				removeFollowerShanks();
			
			else if(numero == 8)
				getMyFollowers();
			
			else if(numero == 9 && numero2 == 1)
				createTreasureOnePiece();
			else if(numero == 9 && numero2 == 2)
				createTreasureHitoHitoNikaModel();
			else if(numero == 9 && numero2 == 3)
				createTreasureTumbaDeShirohige();
			
			else if(numero == 10 && numero2 == 1)
				findTreasureOnePiece();
			else if(numero == 10 && numero2 == 2)
				findTreasureHitoHitoNikaModel();
			else if(numero == 10 && numero2 == 3)
				findTreasureTumbaDeShirohige();
			
			else if(numero == 11)
				getMyTreasuresFound();
			
			else if(numero == 12)
				getMyTreasuresCreated();
			
			else if(numero == 13 && numero2 == 1)
				getMyFollowerTreasuresCreatedLuffy();
			else if(numero == 13 && numero2 == 2)
				getMyFollowerTreasuresCreatedZoro();
			else if(numero == 13 && numero2 == 3)
				getMyFollowerTreasuresCreatedShanks();
			
			else if(numero == 14){
				System.out.println("Saliendo");
			}
			else
				System.err.println("ERROR CON LA OP");
			
			System.out.println("--------------------------------------");
		} while(numero!=14);
		reader.close();
	}
}
