package com.ims.api.jakarta.entities.constant;

public class TaskType {

	public static final String PM 			=	"MAINTENANCE";
	public static final String CM 			= 	"CORRECTIVE";
	public static final String DEPLOY 		= 	"DEPLOY";
	public static final String PULLOUT 		= 	"PULL OUT";
	public static final String REPLACE 		= 	"REPLACE";
	
	public static final String PM_ID 		= 	"Pemeliharaan";
	public static final String CM_ID 		= 	"Perbaikan";
	public static final String DEPLOY_ID 	=	"Pemasangan";
	public static final String PULLOUT_ID 	= 	"Penarikan";
	public static final String REPLACE_ID 	= 	"Penggantian";
	
	
	
	/*
	public static final String PM_ENG 		= TaskType.getTaskType(Lang.IND,TypeStatus.PM);

	enum Lang{ IND, ENG };
	
	enum TypeStatus{	
		PM, 
		CM,	
		DEPLOY,	
		PULLOUT,	
		REPLACE
		};
	
	public static String getTaskType(Lang lang, TypeStatus T) {
		return null;
	}
	*/
	
}
