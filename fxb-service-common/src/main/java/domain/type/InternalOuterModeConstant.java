package domain.type;
/**
 * 向外划转的模式
     * 1：先扣会员内部余额再扣外部余额
     * 2：先加会员外部余额再加内部余额
     * 3：与会员账户无关
 * @author cxp
 *
 */
public class InternalOuterModeConstant {
	/**
	 * 先操作会员内部钱包
	 */
	static public int innerWalletFirst =1;
	/**
	 * 先操作会员外部钱包
	 */
	static public int outerWalletFirst =2;
	/**
	 * 和会员无关
	 */
	static public int irrelevantMemberWallet =3;
}
