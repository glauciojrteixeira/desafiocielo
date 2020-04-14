package br.com.elo.desafiocielo.repositories.utils;

public class QueryUtil {
	
	public static final String QRYBUSCARTODAS = "SELECT c.data_lancamento_conta_corrente_cliente, b.nome_tipo_operacao,  b.numero_remessa_banco,  b.nome_situacao_remessa, c.data_efetiva_lancamento,  c.nome_banco, a.numero_agencia, a.numero_conta_corrente, c.valor_lancamento_remessa FROM domicilio_bancario as a INNER JOIN lancamento_conta_corrente b ON a.id = b.domicilio_bancario_id	INNER JOIN controle_lancamento c ON b.id = c.lancamento_conta_corrente_id";
	
//	public static final String QRYBUSCARTODAS1 = "SELECT fg_stg005.GW_STG000COD_SIS_GOV AS \"GW_STG000COD_SIS_GOV\", \r\n" + 
//			"  fg_stg005.GW_STG001NRO_ISO_PIS_IPT AS \"GW_STG001NRO_ISO_PIS_IPT\", \r\n" + 
//			"  fg_stg005.FG_STG005NRO_ANO_REF_FCT AS \"FG_STG005NRO_ANO_REF_FCT\", \r\n" + 
//			"  fg_stg005.FG_STG005NRO_MES_REF_FCT AS \"FG_STG005NRO_MES_REF_FCT\", \r\n" +  
//			"  fg_stg005.FG_STG005NOM_CCL_CLD AS \"FG_STG005NOM_CCL_CLD\", \r\n" + 
//			"  fg_stg005.FG_STG005DTA_INI_CCL_FCT AS \"FG_STG005DTA_INI_CCL_FCT\", \r\n" + 
//			"  fg_stg005.FG_STG005DTA_FIN_CCL_FCT AS \"FG_STG005DTA_FIN_CCL_FCT\",\r\n" + 
//			"  fg_stg006.FG_STG006NOM_EVT_CCL_FCT AS \"FG_STG006NOM_EVT_CCL_FCT\", \r\n" + 
//			"  fg_stg006.FG_STG006DSC_EVT_CCL_FCT AS \"FG_STG006DSC_EVT_CCL_FCT\", \r\n" + 
//			"  fg_stg006.FG_STG006DTA_INI_EVT_CCL_FCT AS \"FG_STG006DTA_INI_EVT_CCL_FCT\", \r\n" + 
//			"  fg_stg006.FG_STG006DTA_FIN_EVT_CCL_FCT AS \"FG_STG006DTA_FIN_EVT_CCL_FCT\", \r\n" + 
//			"  fg_stg007.FG_STG007NRO_MSG_EVT AS \"FG_STG007NRO_MSG_EVT\", \r\n" + 
//			"  fg_stg007.FG_STG007AST_MSG_EVT AS \"FG_STG007AST_MSG_EVT\", \r\n" + 
//			"  fg_stg007.FG_STG007CND_MSG_EVT AS \"FG_STG007CND_MSG_EVT\", \r\n" + 
//			"  fg_stg008.FG_STG008DTA_INI_PUB_MSG_EVT AS \"FG_STG008DTA_INI_PUB_MSG_EVT\", \r\n" + 
//			"  fg_stg008.FG_STG008DAT_FIN_PUB_MSG_EVT AS \"FG_STG008DAT_FIN_PUB_MSG_EVT\",  \r\n" + 
//			"  fg_stg009.FG_STG009DTA_INS AS \"FG_STG009DTA_INS\", \r\n" + 
//			"  fg_stg009.FG_STG009NOM_EPD_INS AS \"FG_STG009NOM_EPD_INS\", \r\n" + 
//			"  fg_stg009.FG_STG003NRO_PFL_USR_MSG AS \"FG_STG003NRO_PFL_USR_MSG\", \r\n" + 
//			"  fg_stg003.FG_STG003NOM_PFL_USR AS \"FG_STG003NOM_PFL_USR\", \r\n" + 
//			"  fg_stg001.FG_STG001IND_ATV AS \"FG_STG001IND_ATV\", \r\n" + 
//			"  fg_stg001.FG_STG001DAT_DTV AS \"FG_STG001DAT_DTV\", \r\n" + 
//			"  fg_stg001.FG_STG001USR_ADY AS \"FG_STG001USR_ADY\", \r\n" + 
//			"  gw_stg020.GW_STG020COD_MTL_EPD AS \"GW_STG020COD_MTL_EPD\", \r\n" + 
//			"  gw_stg020.GW_STG020NOM_EPD AS \"GW_STG020NOM_EPD\", \r\n" + 
//			"  gw_stg020.GW_STG020SBN_EPD AS \"GW_STG020SBN_EPD\", \r\n" + 
//			"  gw_stg020.GW_STG020SDE_EPD AS \"GW_STG020SDE_EPD\", \r\n" + 
//			"  gw_stg020.GW_STG020EML_ENG_EPD AS \"GW_STG020EML_ENG_EPD\" \r\n" + 
//			"  FROM FG_STG005CCL_FCT fg_stg005 \r\n" + 
//			"  INNER JOIN FG_STG006EVT_CCL_FCT fg_stg006 \r\n" + 
//			"    ON fg_stg005.FG_STG005NRO_ANO_REF_FCT = fg_stg006.FG_STG005NRO_ANO_REF_FCT \r\n" + 
//			"      AND fg_stg005.FG_STG005NRO_MES_REF_FCT = fg_stg006.FG_STG005NRO_MES_REF_FCT \r\n" + 
//			"      AND fg_stg005.GW_STG000COD_SIS_GOV = fg_stg006.GW_STG000COD_SIS_GOV \r\n" + 
//			"      AND fg_stg005.GW_STG001NRO_ISO_PIS_IPT = fg_stg006.GW_STG001NRO_ISO_PIS_IPT \r\n" + 
//			"  INNER JOIN FG_STG008DUR_MSG_EVT fg_stg008 \r\n" + 
//			"    ON fg_stg006.GW_STG000COD_SIS_GOV = fg_stg008.GW_STG000COD_SIS_GOV \r\n" + 
//			"      AND fg_stg006.GW_STG001NRO_ISO_PIS_IPT = fg_stg008.GW_STG001NRO_ISO_PIS_IPT \r\n" + 
//			"      AND fg_stg006.FG_STG005NRO_ANO_REF_FCT = fg_stg008.FG_STG005NRO_ANO_REF_FCT \r\n" + 
//			"      AND fg_stg006.FG_STG005NRO_MES_REF_FCT = fg_stg008.FG_STG005NRO_MES_REF_FCT \r\n" + 
//			"      AND fg_stg006.FG_STG006NRO_EVT_CCL_FCT = fg_stg008.FG_STG006NRO_EVT_CCL_FCT \r\n" + 
//			"  INNER JOIN FG_STG007MSG_EVT fg_stg007 \r\n" + 
//			"    ON fg_stg008.FG_STG007NRO_MSG_EVT = fg_stg007.FG_STG007NRO_MSG_EVT \r\n" + 
//			"  INNER JOIN FG_STG009MSG_EVT_PFL_USR fg_stg009 \r\n" + 
//			"    ON fg_stg008.GW_STG000COD_SIS_GOV = fg_stg009.GW_STG000COD_SIS_GOV \r\n" + 
//			"      AND fg_stg008.GW_STG001NRO_ISO_PIS_IPT = fg_stg009.GW_STG001NRO_ISO_PIS_IPT \r\n" + 
//			"      AND fg_stg008.FG_STG005NRO_ANO_REF_FCT = fg_stg009.FG_STG005NRO_ANO_REF_FCT \r\n" + 
//			"      AND fg_stg008.FG_STG005NRO_MES_REF_FCT = fg_stg009.FG_STG005NRO_MES_REF_FCT \r\n" + 
//			"      AND fg_stg008.FG_STG006NRO_EVT_CCL_FCT = fg_stg009.FG_STG006NRO_EVT_CCL_FCT \r\n" + 
//			"      AND fg_stg008.FG_STG007NRO_MSG_EVT = fg_stg009.FG_STG007NRO_MSG_EVT \r\n" + 
//			"  INNER JOIN FG_STG003PFL_USR_MSG fg_stg003 \r\n" + 
//			"    ON fg_stg009.FG_STG003NRO_PFL_USR_MSG = fg_stg003.FG_STG003NRO_PFL_USR_MSG \r\n" + 
//			"  INNER JOIN FG_STG001USR_FIN fg_stg001 \r\n" + 
//			"    ON fg_stg003.FG_STG003NRO_PFL_USR_MSG = fg_stg001.FG_STG003PFL_USR_MSG_FG_STG003NRO_PFL_USR_MSG \r\n" + 
//			"  INNER JOIN GW_STG020EPD gw_stg020 \r\n" + 
//			"    ON fg_stg001.GW_STG020EPD_GW_STG020COD_MTL_EPD = gw_stg020.GW_STG020COD_MTL_EPD \r\n" + 
//			"WHERE fg_stg005.FG_STG005DTA_INI_CCL_FCT <= :dataAtual01 \r\n" + 
//			"  AND fg_stg005.FG_STG005DTA_FIN_CCL_FCT >= :dataAtual02 \r\n" + 
//			"  AND fg_stg008.FG_STG008DTA_INI_PUB_MSG_EVT <= :dataAtual03 \r\n" + 
//			"  AND fg_stg008.FG_STG008DAT_FIN_PUB_MSG_EVT >= :dataAtual04";
}
