
/**
 * UPMGeoCachingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package sos.fi.upm.es;
/**
 *  UPMGeoCachingSkeleton java skeleton for the axisService
 */

import java.rmi.RemoteException;

import backend.t3.sos.fi.upm.es.UPMAuthenticationAuthorizationWSSkeletonStub;
import backend.t3.sos.fi.upm.es.UPMAuthenticationAuthorizationWSSkeletonStub.*;

import org.apache.axis2.context.*;

import es.upm.fi.sos.AddFollowerResponse;
import es.upm.fi.sos.ChangePasswordResponse;
import es.upm.fi.sos.CreateTreasureResponse;
import es.upm.fi.sos.FindTreasureResponse;
import es.upm.fi.sos.GetMyFollowerTreasuresCreatedResponse;
import es.upm.fi.sos.GetMyFollowersResponse;
import es.upm.fi.sos.GetMyTreasuresCreatedResponse;
import es.upm.fi.sos.GetMyTreasuresFoundResponse;
import es.upm.fi.sos.RemoveFollowerResponse;
import es.upm.fi.sos.model.xsd.FollowerList;
import es.upm.fi.sos.model.xsd.PasswordPair;
import es.upm.fi.sos.model.xsd.Response;
import es.upm.fi.sos.model.xsd.Treasure;
import es.upm.fi.sos.model.xsd.TreasureList;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;




public class UPMGeoCachingSkeleton {
	private String nombreUser;
	private boolean loggeado;
	private static Map <String,Boolean> mapaLoggeados;

	// MAPA PARA SEGUIDORES clave - nombre, valor = Set con Strings de los nombres de los seguidores
	private static Map<String,Set<String>> mapaSeguidores;
	// MAPA PARA SEGUIDOS   clave - nombre, valor = Set con Strings de los usuarios a los que sigo
	private static Map<String,Set<String>> mapaSeguidos;


	// MAPA TESOROS clave - nombre del tesoro, valor = Objeto tesoro
	private static Map<String,Treasure> mapaTesoros;

	// MAPA CREADOS clave - nombre del Creador, valor = Set Strings nombres de los tesoros
	private static Map<String,Set<String>> mapaCreados;

	// MAPA ENCONTRADOS clave = nombre del Usuario, valor = Set Strings nombre de los tesoros
	private static Map<String,Set<String>> mapaEncontrados;

	private static String adminPwd;

	public UPMGeoCachingSkeleton(){
		this.nombreUser = "NO INIT";
		loggeado = false;
		if(mapaLoggeados == null){
			mapaLoggeados = new HashMap<String,Boolean>();
		}
		if(mapaSeguidores == null){
			mapaSeguidores = new HashMap<String,Set<String>>();
		}
		if(mapaSeguidos == null){
			mapaSeguidos = new HashMap<String,Set<String>>();
		}
		if(mapaCreados == null){
			mapaCreados = new HashMap<String,Set<String>>();
		}
		if(mapaEncontrados == null){
			mapaEncontrados = new HashMap<String,Set<String>>();
		}
		if(mapaTesoros == null){
			mapaTesoros = new HashMap<String,Treasure>();
		}
		if(adminPwd == null){
			adminPwd = "admin";
		}
		System.out.println("ADMIN PWD = "+ adminPwd);
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param addUser 
	 * @return addUserResponse 
	 * @throws RemoteException 
	 */

	public es.upm.fi.sos.AddUserResponse addUser (es.upm.fi.sos.AddUser addUser) throws RemoteException{
		this.loggeado = this.mapaLoggeados.containsKey(this.nombreUser);
		System.out.println("ADD USER");
		System.out.println("	-Usuario = " + this.nombreUser + ", Loggeado = "+this.loggeado);
		es.upm.fi.sos.AddUserResponse res = new es.upm.fi.sos.AddUserResponse();
		es.upm.fi.sos.model.xsd.AddUserResponse res2 = new es.upm.fi.sos.model.xsd.AddUserResponse();
		res2.setResponse(false);
		String nombre_usuario = "no_operacion";
		if(this.loggeado && "admin".equals(this.nombreUser)){
			es.upm.fi.sos.model.xsd.Username u = addUser.getArgs0();
			UPMAuthenticationAuthorizationWSSkeletonStub stub = new UPMAuthenticationAuthorizationWSSkeletonStub();
			AddUser addUser2 = new AddUser();
			UserBackEnd param = new UserBackEnd();
			nombre_usuario = u.getUsername();
			param.setName(u.getUsername());
			addUser2.setUser(param );
			AddUserResponse addRes = stub.addUser(addUser2);
			AddUserResponseBackEnd AUResBE = addRes.get_return();

			res2.setResponse(AUResBE.getResult());
			res2.setPwd(AUResBE.getPassword());
		}
		System.out.println("	-Resultado: "+res2.getResponse());
		System.out.println("	-Existe usuario: "+this.existeUsuario(nombre_usuario));
		System.out.println("----------------------------------------------------------");
		System.out.println("");
		res.set_return(res2);
		return res;

	}



	/**
	 * Auto generated method signature
	 * 
	 * @param login 
	 * @return loginResponse 
	 */

	public es.upm.fi.sos.LoginResponse login (es.upm.fi.sos.Login login) throws RemoteException{
		//TODO : fill this with the necessary business logic
		this.loggeado = this.mapaLoggeados.containsKey(this.nombreUser);
		System.out.println("LOGIN");
		System.out.println("	-Loggeado = " + this.loggeado+", Nombre= "+this.nombreUser);

		es.upm.fi.sos.LoginResponse resFin = new es.upm.fi.sos.LoginResponse();
		Response res = new Response();

		es.upm.fi.sos.model.xsd.User usuario =  login.getArgs0();
		System.out.println("	-Parametros: Nombre= "+usuario.getName()+", Pwd= "+usuario.getPwd());
		if(this.loggeado){
			if(this.nombreUser.equals(usuario.getName())){
				res.setResponse(true);
			}
			else{
				res.setResponse(false);
			}
		}
		else{
			if("admin".equals(usuario.getName())){
				if(this.adminPwd.equals(usuario.getPwd())){
					this.nombreUser="admin";
					this.loggeado=true;
					res.setResponse(true);
					this.mapaLoggeados.put(this.nombreUser,true);
				}
				else{
					res.setResponse(false);
				}
			}
			else{

				UPMAuthenticationAuthorizationWSSkeletonStub stub = new UPMAuthenticationAuthorizationWSSkeletonStub();
				Login loginUsuario = new Login();
				LoginBackEnd paramLog = new LoginBackEnd();
				paramLog.setName(usuario.getName());
				paramLog.setPassword(usuario.getPwd());
				loginUsuario.setLogin(paramLog);
				LoginResponse resUPMAA = stub.login(loginUsuario);
				LoginResponseBackEnd resLog = resUPMAA.get_return();

				this.loggeado = resLog.getResult();
				System.out.println("LOGGEADO = " + this.loggeado);
				if(this.loggeado){
					this.nombreUser = usuario.getName();
					this.mapaLoggeados.put(this.nombreUser,true);
				}
				res.setResponse(this.loggeado);
			}
		}
		System.out.println("	-Resultado: "+res.getResponse());
		System.out.println("	-MapaLoggeados: " + this.mapaLoggeados);
		System.out.println("----------------------------------------------------------");
		System.out.println("");
		resFin.set_return(res);	
		return resFin;
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param logout 
	 * @return  
	 */


	public void logout (es.upm.fi.sos.Logout logout) {
		if(!this.loggeado) return;

		this.mapaLoggeados.remove(this.nombreUser);
		this.loggeado = false;
		this.nombreUser = "NO INIT";

	}

	/**
	 * Auto generated method signature
	 * 
	 * @param removeUser 
	 * @return removeUserResponse 
	 */

	public es.upm.fi.sos.RemoveUserResponse removeUser (es.upm.fi.sos.RemoveUser removeUser)throws RemoteException  {
		//TODO : fill this with the necessary business logic
		this.loggeado = this.mapaLoggeados.containsKey(this.nombreUser);
		es.upm.fi.sos.model.xsd.Username usuario = removeUser.getArgs0();
		String username = usuario.getUsername();
		es.upm.fi.sos.RemoveUserResponse resFin = new es.upm.fi.sos.RemoveUserResponse();
		Response resRv  = new Response();
		System.out.println("REMOVE");
		System.out.println("	-Loggeado = " + this.loggeado+", Nombre= "+this.nombreUser);		
		System.out.println("	-Parametros: Nombre= "+username);

		if(this.loggeado && ("admin".equals(this.nombreUser) || this.nombreUser.equals(username))){

			UPMAuthenticationAuthorizationWSSkeletonStub stub = new UPMAuthenticationAuthorizationWSSkeletonStub();

			RemoveUserE removeUser0 = new RemoveUserE();
			RemoveUser param = new RemoveUser();
			param.setName(username);
			removeUser0.setRemoveUser(param );
			RemoveUserResponseE resRvAA = stub.removeUser(removeUser0 );
			RemoveUserResponse resRvFAA = resRvAA.get_return();
			resRv.setResponse(resRvFAA.getResult());
			if(resRvFAA.getResult()){
				this.mapaLoggeados.remove(username);
				mapaSeguidos.remove(username);
				mapaSeguidores.remove(username);
				
				for(Set<String> seguidores : mapaSeguidores.values()){
					seguidores.remove(username);
				}
				for(Set<String> seguidos : mapaSeguidos.values()){
					seguidos.remove(username);
				}
				Set<String> tes = mapaCreados.remove(username);
				for(String t : tes){
					mapaTesoros.remove(t);
				}
				
				mapaEncontrados.remove(username);
				
			}
		}
		else{
			resRv.setResponse(false);
		}
		System.out.println("	-Resultado: "+resRv.getResponse());
		System.out.println("	-MapaLoggeados: "+this.mapaLoggeados);
		System.out.println("	-Existe usuario: "+this.existeUsuario(username));
		System.out.println("----------------------------------------------------------");
		System.out.println("");


		resFin.set_return(resRv);
		return resFin;
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param changePassword 
	 * @return changePasswordResponse 
	 */

	public es.upm.fi.sos.ChangePasswordResponse changePassword (es.upm.fi.sos.ChangePassword changePassword) throws RemoteException{
		//TODO : fill this with the necessary business logic

		ChangePasswordResponse resF = new ChangePasswordResponse();
		Response resCP = new Response();

		resCP.setResponse(false);
		PasswordPair passPair = changePassword.getArgs0();

		System.out.println("Change PassWord");
		System.out.println("	-Loggeado = " + this.loggeado+", Nombre= "+this.nombreUser);		
		System.out.println("	-Parametros: OldPwd = " + passPair.getOldpwd()+ ", NewPwd = " + passPair.getNewpwd() );

		if(this.loggeado){
			// TODO FALTA EL ADMIN
			if(this.nombreUser.equals("admin")){
				if(this.adminPwd.equals(passPair.getOldpwd())){
					this.adminPwd = passPair.getNewpwd();
					resCP.setResponse(true);	
				}
				else{
					resCP.setResponse(false);
				}

			}
			else{
				UPMAuthenticationAuthorizationWSSkeletonStub stub = new UPMAuthenticationAuthorizationWSSkeletonStub();	

				ChangePassword changePassword8 = new ChangePassword();
				ChangePasswordBackEnd param = new ChangePasswordBackEnd();
				param.setName(this.nombreUser);
				param.setOldpwd(passPair.getOldpwd());
				param.setNewpwd(passPair.getNewpwd());

				changePassword8.setChangePassword(param );
				ChangePasswordResponseE resUPMAA = stub.changePassword(changePassword8);
				backend.t3.sos.fi.upm.es.UPMAuthenticationAuthorizationWSSkeletonStub.ChangePasswordResponse resx = resUPMAA.get_return();

				resCP.setResponse(resx.getResult());
			}
		}
		System.out.println("	-Resultado: "+resCP.getResponse());
		System.out.println("----------------------------------------------------------");
		System.out.println("");
		resF.set_return(resCP);
		return resF ;
	}





	private boolean existeUsuario(String Username) throws RemoteException{		
		UPMAuthenticationAuthorizationWSSkeletonStub stub = new UPMAuthenticationAuthorizationWSSkeletonStub();	
		ExistUser existUser4 = new ExistUser();
		backend.t3.sos.fi.upm.es.UPMAuthenticationAuthorizationWSSkeletonStub.Username param = new backend.t3.sos.fi.upm.es.UPMAuthenticationAuthorizationWSSkeletonStub.Username();
		param.setName(Username);
		existUser4.setUsername(param );
		ExistUserResponseE resEx = stub.existUser(existUser4);
		ExistUserResponse resF = resEx.get_return();
		return resF.getResult();

	}

	/**
	 * Auto generated method signature
	 * 
	 * @param addFollower 
	 * @return addFollowerResponse 
	 */

	public es.upm.fi.sos.AddFollowerResponse addFollower (es.upm.fi.sos.AddFollower addFollower)throws RemoteException {
		this.loggeado = this.mapaLoggeados.containsKey(this.nombreUser);
		es.upm.fi.sos.model.xsd.Username username = addFollower.getArgs0();
		AddFollowerResponse resF = new AddFollowerResponse();
		Response resF2= new Response();
		resF2.setResponse(false);
		System.out.println("ADDFOLLOWER");
		System.out.println("    -Loggeado = " + this.loggeado+", Nombre= "+this.nombreUser);
		System.out.println("    -Parametros: Nombre= "+username.getUsername());
		if(this.loggeado && existeUsuario(username.getUsername())){
			Set<String> seguidores;
			if(mapaSeguidores.containsKey(username.getUsername())){
				seguidores = mapaSeguidores.get(username.getUsername());
				seguidores.add(this.nombreUser);
			}
			else{
				seguidores=new HashSet<String>();
				seguidores.add(this.nombreUser);
				mapaSeguidores.put(username.getUsername(), seguidores);
			}
			
			Set<String> seguidos; // this.nombreUser
			if(mapaSeguidos.containsKey(this.nombreUser)){
				seguidos = mapaSeguidos.get(this.nombreUser);
				seguidos.add(username.getUsername());
			}
			else{
				seguidos = new HashSet<String>();
				seguidos.add(username.getUsername());
				mapaSeguidos.put(this.nombreUser, seguidos);
			}
			resF2.setResponse(true);
		}
		System.out.println("    -Resultado: "+resF2.getResponse());
		System.out.println("    -MapaSeguidores: "+this.mapaSeguidores);
		System.out.println("    -MapaSeguidos: "+this.mapaSeguidos);
		System.out.println("----------------------------------------------------------");
		System.out.println("");

		resF.set_return(resF2);
		return resF;
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param removeFollower 
	 * @return removeFollowerResponse 
	 */

	public es.upm.fi.sos.RemoveFollowerResponse removeFollower (es.upm.fi.sos.RemoveFollower removeFollower) throws RemoteException {
		this.loggeado = this.mapaLoggeados.containsKey(this.nombreUser);
		es.upm.fi.sos.model.xsd.Username username = removeFollower.getArgs0();
		RemoveFollowerResponse resF = new RemoveFollowerResponse();
		Response resF2= new Response();
		resF2.setResponse(false);

		System.out.println("REMOVEFOLLOWER");
		System.out.println("    -Loggeado = " + this.loggeado+", Nombre= "+this.nombreUser);
		System.out.println("    -Parametros: Nombre= "+username.getUsername());

		if(this.loggeado && existeUsuario(username.getUsername())){
			Set<String> seguidores;
			if(mapaSeguidores.containsKey(username.getUsername())){
				seguidores = mapaSeguidores.get(username.getUsername());
				seguidores.remove(this.nombreUser);
				resF2.setResponse(true);
			} 

			Set<String> seguidos;
			if(mapaSeguidos.containsKey(this.nombreUser)){
				seguidos = mapaSeguidos.get(this.nombreUser);
				seguidos.remove(username.getUsername());
				resF2.setResponse(true);

			}
		}
		System.out.println("    -Resultado: "+resF2.getResponse());
		System.out.println("    -MapaSeguidores: "+this.mapaSeguidores);
		System.out.println("    -MapaSeguidos: "+this.mapaSeguidos);
		System.out.println("----------------------------------------------------------");
		System.out.println("");
		resF.set_return(resF2);
		return resF;
	}
	/**
	 * Auto generated method signature
	 * 
	 * @param getMyTreasuresFound 
	 * @return getMyTreasuresFoundResponse 
	 */



	/**
	 * Auto generated method signature
	 * 
	 * @param getMyFollowers 
	 * @return getMyFollowersResponse 
	 */

	public es.upm.fi.sos.GetMyFollowersResponse getMyFollowers (es.upm.fi.sos.GetMyFollowers getMyFollowers) throws RemoteException {
		this.loggeado = this.mapaLoggeados.containsKey(this.nombreUser);
		String usuario = this.nombreUser;
		GetMyFollowersResponse resF = new GetMyFollowersResponse();
		FollowerList param= new FollowerList();
		param.setResult(false);
		System.out.println("GETMYFOLLOWERS");
		System.out.println("	-Loggeado = " + this.loggeado+", Nombre= "+this.nombreUser);		

		if(this.loggeado && existeUsuario(usuario)){
			Set<String> seguidores;
			if(mapaSeguidos.containsKey(usuario)){
				seguidores = mapaSeguidos.get(usuario);
				String[] seg = new String[seguidores.size()];
 				int i = 0;
				for(String s : seguidores){
 					seg[i] = s;
					i++;
 				}
				param.setFollowers(seg);	
			}
			else
			{
				param.setFollowers(new String[0]);
			}
			
			param.setResult(true);
		}
		System.out.println("    -Resultado: "+param.getResult());
		System.out.println("	-Longitud de la lista: " + param.getFollowers().length);	
		System.out.println("	-Imprimir el array: " + Arrays.toString(param.getFollowers()));	
		System.out.println("----------------------------------------------------------");
		System.out.println("");
		resF.set_return(param);
		return resF;
	}


	/**
	 * Auto generated method signature
	 * 
	 * @param getMyTreasuresCreated 
	 * @return getMyTreasuresCreatedResponse 
	 */







	/**
	 * Auto generated method signature
	 * 
	 * @param createTreasure 
	 * @return createTreasureResponse 
	 */

	public es.upm.fi.sos.CreateTreasureResponse createTreasure (es.upm.fi.sos.CreateTreasure createTreasure) {
		//TODO : fill this with the necessary business logic
		this.loggeado = this.mapaLoggeados.containsKey(this.nombreUser);
		CreateTreasureResponse resF = new CreateTreasureResponse();
		Response resF2= new Response();
		resF2.setResponse(false);	
		Treasure tesoro = createTreasure.getArgs0();


		System.out.println("CREATE TREASURE");
		System.out.println("	-Loggeado = " + this.loggeado+", Nombre= "+this.nombreUser);
		System.out.println("    -Tesoro: "+tesoro);

		
		if(this.loggeado){
			System.out.print("Tesoro: "+ tesoro);
			mapaTesoros.put(tesoro.getName(), tesoro);
			resF2.setResponse(true);
			Set<String> tesorosC;
			if(mapaCreados.containsKey(this.nombreUser)){
				tesorosC = mapaCreados.get(this.nombreUser);
				tesorosC.add(tesoro.getName());
			}
			else{
				tesorosC = new HashSet<String>();
				tesorosC.add(tesoro.getName());
				mapaCreados.put(this.nombreUser, tesorosC);
			}
			
			
		}
		System.out.println("    -Resultado: "+resF2.getResponse());
		System.out.println("    -Tesoros: "+mapaTesoros);
		System.out.println("    -Creados: "+mapaCreados);
		System.out.println("----------------------------------------------------------");
		System.out.println("");
		
		resF.set_return(resF2);
		return resF;
		
	}

	
	public es.upm.fi.sos.GetMyTreasuresCreatedResponse getMyTreasuresCreated (es.upm.fi.sos.GetMyTreasuresCreated getMyTreasuresCreated) {
		//TODO : fill this with the necessary business logic
		this.loggeado = this.mapaLoggeados.containsKey(this.nombreUser);
		GetMyTreasuresCreatedResponse resF = new GetMyTreasuresCreatedResponse();
		TreasureList param = new TreasureList();
		param.setResult(false);
		
		System.out.println("GET CREATED TREASURES");
		System.out.println("	-Loggeado = " + this.loggeado+", Nombre= "+this.nombreUser);
		if(this.loggeado){
			if(mapaCreados.containsKey(this.nombreUser)){
				Set<String> nombresTesoros = mapaCreados.get(this.nombreUser);
				String[] names = new String[nombresTesoros.size()];
				double[] lats = new double[nombresTesoros.size()];
				double[] alts = new double[nombresTesoros.size()];
 				int i = 0;
				for(String s : nombresTesoros){
 					Treasure t = mapaTesoros.get(s);
					names[i] = t.getName();
					lats[i] = t.getLatitude();
					alts[i] = t.getAltitude();
 					i++;
 				}
				param.setNames(names);
				param.setLats(lats);
				param.setAlts(alts);
			}
			else{
				param.setAlts(new double[0]);
				param.setLats(new double[0]);
				param.setNames(new String[0]);
				
			}
			param.setResult(true);
			
		}
		System.out.println("    -Resultado: "+param.getResult());
		System.out.println("    -Encontrados: "+mapaEncontrados);
		System.out.println("----------------------------------------------------------");
		System.out.println("");
		
		
		resF.set_return(param);
		return resF;
	}



	/**
	 * Auto generated method signature
	 * 
	 * @param findTreasure 
	 * @return findTreasureResponse 
	 */

	public es.upm.fi.sos.FindTreasureResponse findTreasure (es.upm.fi.sos.FindTreasure findTreasure){
		//TODO : fill this with the necessary business logic
		this.loggeado = this.mapaLoggeados.containsKey(this.nombreUser);
		FindTreasureResponse resF = new FindTreasureResponse();
		Response resF2= new Response();
		resF2.setResponse(false);
		Treasure tesoro = findTreasure.getArgs0();

		System.out.println("FIND TREASURE");
		System.out.println("	-Loggeado = " + this.loggeado+", Nombre= "+this.nombreUser);
		System.out.println("    -Tesoro: "+tesoro + ", Nombre Tesoro = "+ tesoro.getName());
		
		if(this.loggeado && mapaTesoros.containsKey(tesoro.getName())){
			Set<String> tesorosC;
			if(mapaEncontrados.containsKey(this.nombreUser)){
				tesorosC = mapaEncontrados.get(this.nombreUser);
				tesorosC.add(tesoro.getName());
			}
			else{
				tesorosC = new HashSet<String>();
				tesorosC.add(tesoro.getName());
				mapaEncontrados.put(this.nombreUser, tesorosC);
			}
		}
		
		
		System.out.println("    -Resultado: "+resF2.getResponse());
		System.out.println("    -Tesoros: "+mapaTesoros);
		System.out.println("    -Encontrados: "+mapaEncontrados);
		System.out.println("----------------------------------------------------------");
		System.out.println("");
		resF.set_return(resF2);
		return resF;	}

	public es.upm.fi.sos.GetMyTreasuresFoundResponse getMyTreasuresFound (es.upm.fi.sos.GetMyTreasuresFound getMyTreasuresFound) {
		//TODO : fill this with the necessary business logic
		this.loggeado = this.mapaLoggeados.containsKey(this.nombreUser);
		GetMyTreasuresFoundResponse resF = new GetMyTreasuresFoundResponse();
		TreasureList param = new TreasureList();
		param.setResult(false);
		
		System.out.println("GET FOUND TREASURES");
		System.out.println("	-Loggeado = " + this.loggeado+", Nombre= "+this.nombreUser);
		if(this.loggeado){
			if(mapaEncontrados.containsKey(this.nombreUser)){
				Set<String> nombresTesoros = mapaEncontrados.get(this.nombreUser);
				String[] names = new String[nombresTesoros.size()];
				double[] lats = new double[nombresTesoros.size()];
				double[] alts = new double[nombresTesoros.size()];
 				int i = 0;
				for(String s : nombresTesoros){
 					Treasure t = mapaTesoros.get(s);
					names[i] = t.getName();
					lats[i] = t.getLatitude();
					alts[i] = t.getAltitude();
 					i++;
 				}
				param.setNames(names);
				param.setLats(lats);
				param.setAlts(alts);
			}
			else{
				param.setAlts(new double[0]);
				param.setLats(new double[0]);
				param.setNames(new String[0]);
				
			}
			param.setResult(true);
			
		}
		System.out.println("    -Resultado: "+param.getResult());
		System.out.println("    -Encontrados: "+mapaEncontrados);
		System.out.println("----------------------------------------------------------");
		System.out.println("");
		
		resF.set_return(param);
		return resF;
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param getMyFollowerTreasuresCreated 
	 * @return getMyFollowerTreasuresCreatedResponse 
	 */

	public es.upm.fi.sos.GetMyFollowerTreasuresCreatedResponse getMyFollowerTreasuresCreated(es.upm.fi.sos.GetMyFollowerTreasuresCreated getMyFollowerTreasuresCreated) {
		//TODO : fill this with the necessary business logic
		this.loggeado = this.mapaLoggeados.containsKey(this.nombreUser);
		GetMyFollowerTreasuresCreatedResponse resF = new GetMyFollowerTreasuresCreatedResponse();
		String usuario = getMyFollowerTreasuresCreated.getArgs0().getUsername();
		TreasureList param = new TreasureList();
		param.setResult(false);
		Boolean esSeguidor = true;
		if(this.loggeado && mapaSeguidos.containsKey(this.nombreUser)){
			Set<String> seguidos = mapaSeguidos.get(this.nombreUser);
			esSeguidor = seguidos.contains(usuario);
		}
		else{
			esSeguidor = false;
		}
		
		System.out.println("GET CREATED TREASURES");
		System.out.println("	-Loggeado = " + this.loggeado+", Nombre= "+this.nombreUser);
		System.out.println("	-Seguidor = " + usuario);
		if(this.loggeado && esSeguidor){
			if(mapaCreados.containsKey(usuario)){
				Set<String> nombresTesoros = mapaCreados.get(usuario);
				String[] names = new String[nombresTesoros.size()];
				double[] lats = new double[nombresTesoros.size()];
				double[] alts = new double[nombresTesoros.size()];
 				int i = 0;
				for(String s : nombresTesoros){
 					Treasure t = mapaTesoros.get(s);
					names[i] = t.getName();
					lats[i] = t.getLatitude();
					alts[i] = t.getAltitude();
 					i++;
 				}
				param.setNames(names);
				param.setLats(lats);
				param.setAlts(alts);
			}
			else{
				param.setAlts(new double[0]);
				param.setLats(new double[0]);
				param.setNames(new String[0]);
				
			}
			param.setResult(true);
			
		}
		System.out.println("    -Resultado: "+param.getResult());
		System.out.println("    -Es Seguidor: "+esSeguidor);
		System.out.println("    -Encontrados: "+mapaEncontrados);
		System.out.println("----------------------------------------------------------");
		System.out.println("");
		
		
		resF.set_return(param);
		return resF;
	}





}