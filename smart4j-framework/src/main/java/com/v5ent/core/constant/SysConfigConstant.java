package com.v5ent.core.constant;

/**
 * 
 * @描述：系统配置常量
 *
 * @author Bob
 * @时间  2015年8月5日上午9:51:24
 *
 */
public class SysConfigConstant {
	
	/**
	 * 注册验证短信模板
	 */
	public static final String REG_VCODE_FORMAT = "reg_vcode_format";
	/**
	 * 短信partnerid
	 */
	public static final String SEND_VCODE_PARTNERID = "send_vcode_partnerid";
	/**
	 * 短信moduleid
	 */
	public static final String SEND_VCODE_MODULEID = "send_vcode_moduleid";
	/**
	 * 微信配置类别
	 */
	public static final String TYPE_WECHAT_URL = "wechat_url";
	
	/**
	 * 微信配置类别
	 */
	public static final String TYPE_WECHAT = "wechat";
	
	/**
	 * 微信分享
	 */
	public static final String WECHAT_SHARE = "wechat_share";
	/**
	 * 微信分享
	 */
	public static final String WECHAT_SHARE_DESC = "wechat_share_desc";
	/**
	 * 微信分享
	 */
	public static final String WECHAT_SHARE_IMGURL = "wechat_share_imgurl";
	
	/**
	 * 微信分享-客户
	 */
	public static final String WECHAT_SHARE_LINK = "wechat_share_link";
	
	/**
	 * 微信分享
	 */
	public static final String WECHAT_SHARE_TITLE = "wechat_share_title";
	
	
	/**
	 * 微信分享-客户
	 */
	public static final String WECHAT_SHARE_CUSTOMER = "wechat_share_customer";
	/**
	 * 微信分享-客户
	 */
	public static final String WECHAT_SHARE_CUSTOMER_DESC = "wechat_share_customer_desc";
	/**
	 * 微信分享-客户
	 */
	public static final String WECHAT_SHARE_CUSTOMER_IMGURL = "wechat_share_customer_imgurl";
	/**
	 * 微信分享-客户
	 */
	public static final String WECHAT_SHARE_CUSTOMER_LINK = "wechat_share_customer_link";
	/**
	 * 微信分享-客户
	 */
	public static final String WECHAT_SHARE_CUSTOMER_TITLE = "wechat_share_customer_title";
	
	/**
	 * 微信分享理财师-客户
	 */
	public static final String WECHAT_SHARE_LCS_CUSTOMER = "wechat_share_lcs_customer";
	/**
	 * 微信分享理财师-客户
	 */
	public static final String WECHAT_SHARE_LCS_CUSTOMER_DESC = "wechat_share_lcs_customer_desc";
	/**
	 * 微信分享理财师-客户
	 */
	public static final String WECHAT_SHARE_LCS_CUSTOMER_IMGURL = "wechat_share_lcs_customer_imgurl";
	/**
	 * 微信分享理财师-客户
	 */
	public static final String WECHAT_SHARE_LCS_CUSTOMER_LINK = "wechat_share_lcs_customer_link";
	/**
	 * 微信分享理财师-客户
	 */
	public static final String WECHAT_SHARE_LCS_CUSTOMER_TITLE = "wechat_share_lcs_customer_title";
	
	/**
	 * 微信公众号appId
	 */
	public static final String WECHAT_APP_ID = "appid";
	/**
	 * 微信公众号secret
	 */
	public static final String WECHAT_APP_SECRET = "app_secret";
	
	/**
	 * 框架圈微信公众号appId
	 */
	public static final String LINGHUIQUAN_WECHAT_APP_ID = "linghuiquan_wechat_app_id";
	/**
	 * 框架圈微信公众号secret
	 */
	public static final String LINGHUIQUAN_WECHAT_APP_SECRET = "linghuiquan_wechat_app_secret";
	/**
	 * 微信获取accessToken接口
	 */
	public static final String WECHAT_URL_ACCESS_TOKEN = "url_access_token";
	/**
	 * 微信获取用户信息接口
	 */
	public static final String WECHAT_URL_USER_INFO = "url_user_info";
	
	/**
	 * 注册url
	 */
	public static final String URL_RC_REG = "url_rc_reg";
	
	
	public static final String PUSHMESSAGE_PARTNERID = "pushmessage_partnerid";
	
	public static final String PUSHMESSAGE_RCLCS_ANONYMOUS = "pushmessage_rclcs_anonymous";
	
	public static final String PUSHMESSAGE_RCLCS_SIGN = "pushmessage_rclcs_sign";
	
	public static final String RC_MESSAGE_SIGN =  "rc_message_sign";
	
	public static final String RC_MESSAGE_ANONYMOUS =  "rc_message_anonymous";
	
	/**
	 * 不发送验证码
	 */
	public static final String KEY_NO_SEND_VCODE =  "notype_no_send_vcode";
	
	/**
	 * 预发布不返回错误信息
	 */
	public static final String PRE_NO_RETURN_MSG =  "pre_no_return_msg";
	
	/**
	 * 客户端配置
	 */
	public static final String KEY_CLIENT_CONFIG =  "client_config";
	
	/**
	 * 产品详情地址
	 */
	public static final String URL_PRODUCT_DETAIL_INVESTOR = "url_product_detail_investor";
	/**
	 * 通讯录邀请客户url
	 */
	public static final String MAIL_INVITATION_CUSTOMER_URL = "mail_invitation_customer";
	/**
	 * 通讯录邀请理财师url
	 */
	public static final String MAIL_INVITATION_LCS_URL = "mail_invitation_lcs";
	
	
	/**
	 * 
	 * 金服  用户注册成功
	 */
	public static final String PUSHMESSAGE_CREGISTER = "pushmessage_cregister";
	
	/**
	 * 金服  定期产品到期回款
	 * 
	 */
	public static final String PUSHMESSAGE_CFIXEDRETURN = "pushmessage_cfixedreturn";
	 
	
	/**
	 * 
	 * 金服  定期产品在投资额超（含）10万元，且3天后到期回款  
	 */
	public static final String PUSHMESSAGE_CFIXEDBIGAMOUNTRETURN = "pushmessage_cfixedbigamountreturn";
	/**
	 * 
	 * 金服  提现申请处理完成
	 */
	public static final String  PUSHMESSAGE_CTXAPPLYSUCCESS = "pushmessage_ctxapplysuccess";
	/**
	 * 金服  提现申请处理失败
	 * 
	 */
	public static final String PUSHMESSAGE_CTXAPPLYFAIL = "pushmessage_ctxapplyfail";
	/**
	 * 
	 * 理财师    用户（理财师自己）注册成功
	 */
	public static final String PUSHMESSAGE_LREGISTER = "pushmessage_lregister";
	/**
	 * 
	 * 理财师   客户注册完成
	 */
	public static final String PUSHMESSAGE_LCUSTOMERREGIST = "pushmessage_lcustomerregister";
	/**
	 * 
	 * 投资端   客户邀请客户注册完成
	 */
	public static final String PUSHMESSAGE_CUM_IVIT_CUM = "pushmessage_cum_ivit_cum";
	/**
	 * 
	 * 理财师   平台分配客户
	 */
	public static final String PUSHMESSAGE_LASSIGNCUSTOMER = "pushmessage_lassigancustomer";
	/**
	 * 理财师  团队一级成员注册完成
	 * 
	 */
	public static final String PUSHMESSAGE_LGRADEONEREGISTER="pushmessage_lgradeoneregister";
	/**
	 * 
	 * 理财师  客户购买成功
	 */
	public static final String PUSHMESSAGE_LCUSTOMERBUY = "pushmessage_lcustomerbuy";
	/**
	 * 
	 * 理财师  客户购买成功（募集中）
	 */
	public static final String PUSHMESSAGE_LCUSTOMERBUY_ONCOLLECT = "pushmessage_lcustomerbuy_oncollect";
	/**
	 * 
	 * 理财师  客户购买成功（募集失败）
	 */
	public static final String PUSHMESSAGE_LCUSTOMERBUY_COLLECTFAIL = "pushmessage_lcustomerbuy_collectfail";
	/**
	 * 
	 * 理财师  团队一级成员销售成功
	 */
	public static final String PUSHMESSAGE_LGRADEONESALE = "pushmessage_lgradeonesale";
	
	/**
	 * 
	 * 理财师  团队二级成员销售成功
	 */
	public static final String PUSHMESSAGE_LGRADETWOSALE = "pushmessage_lgradetwosale";
	/**
	 * 
	 * 理财师  客户活期宝赎回完成
	 */
	public static final String PUSHMESSAGE_LCUSTOMERCURRENTRETURN = "pushmessage_lcustomercurrentreurn";
	/**
	 * 
	 * 理财师  客户定期产品到期回款
	 */
	public static final String PUSHMESSAGE_LCUSTOMERFIXEDRETURN = "pushmessage_lcustomerfixedreturn";
	/**
	 * 理财师  客户定期产品在投资额超（含）10万元，且3天后到期回款(浮动产品)
	 * 
	 */
	public static final String PUSHMESSAGE_LCUSTOMERBIGAMOUNTRETURN = "pushmessage_lcustomerbigamountreturn";
	
	/**
	 * 理财师  客户定期产品在投资额超（含）10万元，且3天后到期回款 （定期产品）
	 * 
	 */
	public static final String PUSHMESSAGE_LCUSTOMERBIGAMOUNTRETURN_FIX = "pushmessage_lcustomerbigamountreturn_fix";
	/**
	 * 投资端   客户定期产品在投资额超（含）10万元，且3天后到期回款 
	 * 
	 */
	public static final String PUSHMESSAGE_CUSTOMERBIGAMOUNTRETURN_INV_FLOAT = "pushmessage_customerbigamountreturn_inv_float";
	/**
	 * 
	 * 理财师  客户升级为理财师
	 */
	public static final String PUSHMESSAGE_LCUSTOMERTOLCS = "pushmessage_lcustomertolcs";
	/**
	 * 
	 * 理财师  佣金收益到账
	 */
	public static final String PUSHMESSAGE_LFEERECEIVED = "pushmessage_lfeereceived";
	
	/**
	 * 
	 * 理财师  提现申请处理完成
	 */
	public static final String PUSHMESSAGE_LTXAPPLYSUCCESS = "pushmessage_ltxapplysuccess";
	
	/**
	 * 
	 * 理财师  提现申请处理失败
	 */
	public static final String PUSHMESSAGE_LTXAPPLYFAIL = "pushmessage_ltxapplyfail";
	
	
	/**
	 * 
	 * 理财师  升级
	 */
	public static final String PUSHMESSAGE_LCSUPGRADE = "pushmessage_lcsupgrade";
	
	
	/**
	 * 
	 * 红包过期天数
	 */
	public static final String PUSHMESSAGE_REDPACKETEXPIREDAY = "pushmessage_redpacketexpireday";
	/**
	 * 理财师收到系统红包消息
	 */
	public static final String PUSHMESSAGE_LCSRECEIVESYSREDPAPER = "pushmessage_lcsreceivesysredpaper";
	
	/**
	 * 注册送红包配置
	 */
	public static final String REGISTER_REDPACEKT_IDS = "register_redPacekt_ids";
	public static final String REGISTER_REDPACEKT_SEND_IDS = "register_redPacekt_send_ids";
	public static final String REGISTER_REDPACEKT_SWITCH = "register_redPacekt_switch";
	public static final String REGISTER_LCS_REDPACEKT_MSG = "register_lcs_redPacekt_msg";
	public static final String REGISTER_CUSTOMER_REDPACEKT_MSG = "register_customer_redPacekt_msg";
	/**
	 * 理财师任务红包开关
	 */
	public static final String LCS_TASK_REDPACEKT_CONFIG = "lcs_task_redPacekt_switch"; 
	
	/**
	 * 客户任务红包开关
	 */
	public static final String CUSTOMER_TASK_REDPACEKT_CONFIG = "customer_task_redPacekt_switch"; 
	
	/**
	 * 注册送现金开关
	 */
	public static final String REGISTER_SEND_CASH_SWICTH = "register_send_cash_swicth";
	/**
	 * 理财师推荐注册投资返现红包开关
	 */
	public static final String LCS_RECOMMEND_REGISTER_SENDREDPACEKT_SWICTH = "lcs_recommend_register_sendredpacekt_switch";
	/**
	 * 理财师推荐注册投资返现红包 红包编码和红包发送编码
	 */
	public static final String LCS_RECOMMEND_REGISTER_SENDREDPACEKT_REDPACEKTIDANDSENDID = "lcs_recommend_register_sendredpacekt_redpacektIdAndSendId";
	/**
	 * IOS补丁数据
	 */
	public static final String IOS_PATCH_DATA = "ios_patch_data";
	
	/**
	 * 理财师报单审核通知
	 */
	public static final String DECLARATIONFORM_PASS_NOTICE = "pushmessage_lcs_declarationform_audit_pass_notice";
	public static final String DECLARATIONFORM_FAIL_NOTICE = "pushmessage_lcs_declarationform_audit_fail_notice";
	
	/**
	 * 实名验证开关
	 */
	public static final String VERIFY_REAL_NAME_SWICTH = "verify_real_name_swicth";
	
	/**
	 * 配置的公告消息详情模板
	 */
	public static final String LCS_PUSH_NOTICE_RELEASE_TMP_URL = "bulletinDetailDefaultUrl";

	/**
	 * 每日绑卡限制次数
	 */
	public static final String LIMIT_ACCOUNT_BIND_TIMES = "limit_account_bind_times";
	/**
	 * 
	 * 收到系统发放的活动奖励
	 */
	public static final String PUSHMESSAGE_REC_ACTIVITY_REWARD = "pushmessage_rec_activity_reward";
	/**
	 * 配置不推送短信记录平台
	 */
	public static final String PUSHMESSAGE_UNWANRWS_ORGNUMBER = "pushmessage_unwanted_orgnumber";
	/**
	 * 客户回款理财师推送消息内容
	 */
	public static final String PUSHMESSAGE_INV_RANSOM_LCS = "pushmessage_inv_ransom_lcs";
	public static final String PUSHMESSAGE_INV_PAYBACK_LCS = "pushmessage_inv_payback_lcs";
	public static final String PUSHMESSAGE_COLLECT_FAIL_LCS = "pushmessage_collect_fail_lcs";
	/**
	 * T呗回款 投资端提示
	 */
	public static final String PUSHMESSAGE_PAYBACK_INV = "pushmessage_payback_inv";
	/**
	 * T呗回款 募集失败 投资端提示
	 */
	public static final String PUSHMESSAGE_COLLECT_FAIL_INV = "pushmessage_collect_fail_inv";
	/**
	 * 理财师给客户推荐产品 -投资端消息
	 */
	public static final String PUSHMESSAGE_RECOMEND_PRODUCT_INV = "pushmessage_recomend_product_inv";
	/**
	 * 理财师给客户推荐平台 -投资端消息
	 */
	public static final String PUSHMESSAGE_RECOMEND_PLATFORM_INV = "pushmessage_recomend_platform_inv";
	/**
	 * 第三方账户开设成功
	 */
	public static final String PUSHMESSAGE_THIRD_ACC_BIND_SUCCESS_INV = "pushmessage_third_acc_bind_success_inv";
	/**
	 * 投资成功 投资客户个人消息
	 */
	public static final String PUSHMESSAGE_INVEST_INV = "pushmessage_invest_inv";
	
	public static final String QUARTER_REMARK = "quarter_remark";
	
	/**
	 * 投呗微信公众号AppID-T呗
	 */
	public static final String TOOBEI_APPID ="toobei_appid";
	/**
	 * 投呗微信公众号AppID-猎财
	 */
	public static final String LIECAI_APPID ="liecai_appid";
	/**
	 * 投呗微信公众号AppSecret-T呗
	 */
	public static final String TOOBEI_APPSECRET ="toobei_appsecret";
	/**
	 * 投呗微信公众号AppSecret-猎财
	 */
	public static final String LIECAI_APPSECRET ="liecai_appsecret";
	/**
	 * 投呗微信公众号AccToken-T呗
	 */
	public static final String TOOBEI_ACCTOKEN ="toobei_acctoken";
	/**
	 * 投呗微信公众号AccToken-猎财
	 */
	public static final String LIECAI_ACCTOKEN ="liecai_acctoken";
	/**
	 * 微信消息推送开关-T呗
	 */
	public static final String TOOBEI_WEIXIN_SWICTH ="toobei_weixin_swicth";
	
	/**
	 * 微信消息推送开关-猎财
	 */
	public static final String LIECAI_WEIXIN_SWICTH ="liecai_weixin_swicth";
	
	/**
	 * 微信消息推送URL(根据前端微信code获得用户的openId)-T呗
	 */
	public static final String TOOBEI_QUERY_OPENID_URL ="toobei_query_openid_url";
	/**
	 * 微信消息推送URL(根据前端微信code获得用户的openId)-猎财
	 */
	public static final String LIECAI_QUERY_OPENID_URL ="liecai_query_openid_url";
	
	
	/**
	 * 微信消息推送URL(微信获取acctoken)-T呗
	 */
	public static final String TOOBEI_QUERY_ACCTOKEN_URL ="toobei_query_acctoken_url";
	/**
	 * 微信消息推送URL(微信获取acctoken)-猎财
	 */
	public static final String LIECAI_QUERY_ACCTOKEN_URL ="liecai_query_acctoken_url";
	
	/**
	 * 微信消息推送URL(微信发送消息)-T呗
	 */
	public static final String TOOBEI_SEND_MSG_URL ="toobei_send_msg_url";
	/**
	 * 微信消息推送URL(微信发送消息)-猎财
	 */
	public static final String LIECAI_SEND_MSG_URL ="liecai_send_msg_url";
	
	/**
	 * 微信消息推送-注册成功通知
	 */
	public static final String REGISTER_SUCCESS ="register_success";
	
	/**
	 * 微信消息推送-邀请注册成功通知
	 */
	public static final String INVITATION_REGISTER_SUCCESS ="invitation_register_success";
	
	/**
	 * 微信消息推送-推荐成功通知
	 */
	public static final String RECOMMEND_SUCCESS ="recommend_success";
	
	/**
	 * 微信消息推送-投资成功通知  猎财
	 */
	public static final String LIECAI_INVESTMENT_SUCCESS ="liecai_investment_success";
	
	/**
	 * 微信消息推送-一级推荐奖励  猎财
	 */
	public static final String LIECAI_PARENT_INVESTMENT_SUCCESS ="liecai_parent_investment_success";
	
	/**
	 * 微信消息推送-二级推荐奖励  猎财
	 */
	public static final String LIECAI_GRANDPARENT_INVESTMENT_SUCCESS ="liecai_grandparent_investment_success";
	
	/**
	 * 微信消息推送-投资成功通知
	 */
	public static final String INVESTMENT_SUCCESS ="investment_success";
	
	/**
	 * 微信消息推送-回款提醒
	 */
	public static final String PAYMENT_REMINDER ="payment_reminder";
	
	/**
	 * 微信消息推送-回款提醒-猎财
	 */
	public static final String LIECAI_PAYMENT_REMINDER ="liecai_payment_reminder";
	
	/**
	 * 微信消息推送-回款提醒(客户客户主动赎回／转让产品)-猎财
	 */
	public static final String PAYMENT_REMINDER_ACTIVE ="payment_reminder_active";
	/**
	 * 微信消息推送-到账提醒(佣金)-猎财
	 */
	public static final String ARRIVAL_REMINDER_COMMISSION = "arrival_reminder_commission";
	
	/**
	 * 微信消息推送-佣金到账提醒(线上)-猎财
	 */
	public static final String ARRIVAL_REMINDER_PAYFEE = "arrival_reminder_payfee";
	
	/**
	 * 微信消息推送-到账提醒(Leader)-猎财
	 */
	public static final String ARRIVAL_REMINDER_LEADER = "arrival_reminder_leader";
	
	/**
	 * 微信消息推送-到账提醒(推荐奖励)-猎财
	 */
	public static final String ARRIVAL_REMINDER_RECOMMEND = "arrival_reminder_recommend";
	
	/**
	 * 微信消息推送-回款提醒(产品剩余3天到期回款)
	 */
	public static final String SOON_PAYMENT_REMINDER ="soon_payment_reminder";
	
	/**
	 * 微信消息推送-返现到账通知
	 */
	public static final String RETURN_ACCOUNT ="return_account";
	
	/**
	 * 微信消息推送-提现到账通知
	 */
	public static final String WITHDRAWALS_ACCOUNT ="withdrawals_account";
	
	/**
	 * 微信消息推送-提现申请通知
	 */
	public static final String APPLY_WITHDRAWALS_ACCOUNT ="apply_withdrawals_account";
	
	/**
	 * 微信消息推送-解绑通知
	 */
	public static final String RELEASE_RELATIONSHIP ="release_relationship";
	
	/**
	 * 微信消息推送-解绑成功通知(客户解绑)-猎财
	 */
	public static final String CUSTOMER_RELEASE_RELATIONSHIP ="customer_release_relationship";
	
	/**
	 * 微信消息推送-解绑成功通知(下级解绑)-猎财
	 */
	public static final String SUBORDINATE_RELEASE_RELATIONSHIP ="subordinate_release_relationship";
	
	
	/**
	 * 微信消息推送-解绑成功通知(上级解绑成功)-猎财
	 */
	public static final String SUPERIOR_RELEASE_RELATIONSHIP ="superior_release_relationship";
	
	/**
	 * 微信消息推送-新下级绑定成功通知(新下级绑定成功)-猎财
	 */
	public static final String SUBORDINATE_ADD_RELATIONSHIP ="subordinate_add_relationship";
	
	/**
	 * 微信消息推送-绑定成功通知
	 */
	public static final String BIND_SUCCESS ="bind_success";
	
	/**
	 * 微信消息推送-绑定成功通知(客户绑定)-猎财
	 */
	public static final String CUSTOMER_BIND_SUCCESS ="customer_bind_success";
	
	/**
	 * 微信消息推送-绑定成功通知(上级绑定成功)-猎财
	 */
	public static final String SUPERIOR_BIND_SUCCESS ="superior_bind_success";
	
	/**
	 * 微信消息推送-绑定成功通知(下级绑定成功)-猎财
	 */
	public static final String SUBORDINATE_BIND_SUCCESS ="subordinate__bind_success";
	

	/**
	 * 微信消息推送-第三方账户开设成功通知
	 */
	public static final String OPEN_THIRD_ACCOUNT_SUCCESS ="open_third_account_success";
	
	/**
	 * 微信消息推送-活动完成通知-猎财
	 */
	public static final String ACTIVITY_COMPLETE = "activity_complete";
	
	/**
	 * 微信消息推送-等级变更通知-猎财
	 */
	public static final String GRADE_CHANGE = "grade_change";
	
	/**
	 * 微信消息推送-报单审核未通过-猎财
	 */
	public static final String AUDIT_NOT_PASSED = "audit_not_passed";
	
	/**
	 * 微信消息推送-报单审核通过-猎财
	 */
	public static final String AUDIT_PASSED = "audit_passed";
	/**
	 * 产品详情URL -理财师端
	 */
	public static final String RECOMEND_DETAIL_URL_LCS = "productDetailUrl_channel";
	/**
	 * 产品详情URL -投资端
	 */
	public static final String RECOMEND_DETAIL_URL_INV = "productDetailUrl_investor";
	/**
	 * 解绑理财师
	 */
	public static final String PUSHMESSAGE_LCS_UNBUNDLING = "pushmessage_lcsunbundling";
	/**
	 * 绑定理财师
	 */
	public static final String PUSHMESSAGE_LCS_BUNDLING = "pushmessage_lcsbundling";
	/**
	 * 客户解绑理财师  推消息给理财师
	 */
	public static final String PUSHMESSAGE_LCS_CUSTOMER_UNBUNDLING = "pushmessage_lcs_customer_unbundling";
	/**
	 * 客户解绑理财师  推消息给客户
	 */
	public static final String PUSHMESSAGE_INV_CUSTOMER_UNBUNDLING = "pushmessage_inv_customer_unbundling";
	/**
	 * 客户绑定理财师  推消息给理财师
	 */
	public static final String PUSHMESSAGE_LCS_CUSTOMER_BUNDLING = "pushmessage_lcs_customer_bundling";
	/**
	 * 客户理财师理财师  推消息给客户
	 */
	public static final String PUSHMESSAGE_INV_CUSTOMER_BUNDLING = "pushmessage_inv_customer_bundling";
	
	/**
	 * 周佣榜头像
	 */
	public static final String LCS_ZYB_IMAGE = "lcs_zyb_image";
	
	/**
	 * 猎财大师leader奖励(核算变更-下级解绑)
	 */
	public static final String PUSHMESSAGE_LCS_LEADER_REWARD_SUBORDINATE_UNBIND = "pushmessage_lcs_leader_reward_subordinate_unbind";
	
	/**
	 * leader奖励核算变更(下级拆分)
	 */
	public static final String PUSHMESSAGE_LCS_LEADER_REWARD_SUBORDINATE_SPLIT = "pushmessage_lcs_leader_reward_subordinate_split";
	
	/**
	 * 暂停核算leader奖励(下级解绑)
	 */
	public static final String PUSHMESSAGE_LCS_LEADER_REWARD_PAUSE_SUBORDINATE_UNBIND = "pushmessage_lcs_leader_reward_pause_subordinate_unbind";
	
	/**
	 * 暂停核算leader奖励(下级拆分)
	 */
	public static final String PUSHMESSAGE_LCS_LEADER_REWARD_PAUSE_SUBORDINATE_SPLIT = "pushmessage_lcs_leader_reward_pause_subordinate_split";
	
	/**
	 * 核算leader奖励(符合5+1)
	 */
	public static final String PUSHMESSAGE_LCS_LEADER_REWARD_CALCULATION = "pushmessage_lcs_leader_reward_calculation";
	
	/**
	 * 助力加息活动
	 */
	public static final String PUSHMESSAGE_INV_HELP_RAISE_RATE = "pushmessage_inv_help_raise_rate";
	
	/**
	 * leader奖励开关
	 */
	public static final String LEADER_PROFIT_SWICTH ="leader_profit_swicth";
	
	/**
	 * 直接下级理财师独立核算津贴
	 */
	public static final String PUSHMESSAGE_LCS_SUBORDINATE_ACCOUNTING_REWARD ="pushmessage_lcs_subordinate_accounting_reward";
	
	/**
	 * 
	 * 消息推送 理财师  团队三级成员销售成功
	 */
	//public static final String PUSHMESSAGE_LGRADETHREESALE = "pushmessage_lgradethreesale";
	
	/**
	 * 微信消息推送-三级推荐奖励  猎财
	 */
	public static final String LIECAI_GREAT_GRANDPARENT_INVESTMENT_SUCCESS ="liecai_great_grandparent_investment_success";
	
	/**
	 * 理财师晋级通知  推消息给理财师(见习顾问)
	 */
	public static final String PUSHMESSAGE_LCSJJTZ_JXGW = "pushmessage_lcsjjtz_jxgw";
	/**
	 * 理财师晋级通知  推消息给理财师(经理总监)
	 */
	public static final String PUSHMESSAGE_LCSJJTZ_JLZJ = "pushmessage_lcsjjtz_jlzj";
	
	/**
	 * 切换短信消息通道
	 */
	public static final String CHANGE_MESSAGE_CHANNEL = "change_message_channel";
	/**
	 * 新手福利六连送红包发放开关
	 */
	public static final String LCS_NEWCOMER_WELFARE_TASK_REDPACEKT_SWITCH = "lcs_newcomer_welfare_task_redPacekt_switch"; 
	/**
	 * 六连送-绑卡红包
	 */
	public static final String SEND_SIX_BIND_REDPACKET = "send_six_bind_redpacket";
	/**
	 * 六连送-理财师首次自投
	 */
	public static final String SEND_SIX_ONCE_INVEST = "send_six_once_invest";
	/**
	 * 理财师首次邀请客户
	 */
	public static final String SEND_SIX_ONCE_INVITATION_INVESTOR = "send_six_once_invitation_investor";
	/**
	 * 六连送-首次推荐理财师
	 */
	public static final String SEND_SIX_ONCE_INVITATION_CFP = "send_six_once_invitation_cfp";
	/**
	 * 六连送-所有推荐理财师的首次出单
	 */
	public static final String SEND_SIX_ALL_CFP_INVEST = "send_six_all_cfp_invest";
	/**
	 * 六连送-完成所有新手福利六连送后，点击立即领取288红包
	 */
	public static final String SEND_SIX_END_REDPACKET = "send_six_end_redpacket";
	/**
	 * 六连送消息推送开关
	 */
	public static final String SEND_SIX_MSG_SWITCH = "send_six_msg_switch";
	/**
	 * 光棍节红包发放开关
	 */
	public static final String DOUBLE_ELEVEN_REDPACEKT_SWITCH = "double_eleven_redpacket_switch";
	/**
	 * 光棍节投资红包组合ID
	 */
	public static final String DOUBLE_ELEVEN_REDPACEKT_IDS = "double_eleven_redpacket_ids";
	/**
	 * 光棍节投资红包组合发放ID
	 */
	public static final String DOUBLE_ELEVEN_REDPACEKT_SEND_IDS = "double_eleven_redpacket_send_ids";
	/**
	 * T呗微信分享更新acctoken开关
	 */
	public static final String TOOBEI_WEIXIN_UPDATE_ACCTOKEN_SWICTH = "toobei_weixin_update_acctoken_swicth";
	/**
	 * 猎财微信分享更新acctoken开关
	 */
	public static final String LIECAI_WEIXIN_UPDATE_ACCTOKEN_SWICTH = "liecai_weixin_update_acctoken_swicth";
	/**
	 * 4.5.3保险智能评测-宠爱自己
	 */
	public static final String KIND_TO_MYSELF = "kind_to_myself";
	/**
	 * 4.5.3保险智能评测-健康成长
	 */
	public static final String HEALTHY_GROWTH= "healthy_growth";
	/**
	 * 4.5.3保险智能评测-感恩父母
	 */
	public static final String THANKSGIVING_PARENTS = "thanksgiving_parents";
	/**
	 * 4.5.3保险智能评测-一路有你
	 */
	public static final String THERE_YOU_ALL_THE_WAY = "there_you_all_the_way";
}
