package service.manager;


import domain.UsrWallet;
import domain.entity.*;
import domain.type.UserType;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


public interface UsrWalletManager {
	/***初始化会员钱包
	 * 
	 * @param usrConsumer
	 * @return
	 */
	public UsrWallet initUsrConsumerWallet(UsrConsumer usrConsumer);
	/***
	 * 根据用户类型 和 ID 查询钱包
	 * @param userId
	 * @param
	 * @return
	 */
	public UsrWallet queryUsrWalletByUserId(long userId, int userType);

	/**
	 * 根据用户类型，ID，account
	 * @param map
	 * @return
	 */
	public UsrWallet queryUsrWalletByUserIdAndAccount(Map<String, Object> map);

	/**
	 * 根据用户类型，ID，account
	 * @param map
	 * @return
	 */
	public List<UsrWallet> queryUsrWalletsByUserIdAndAccount(Map<String, Object> map);

	public int updateForAddAbleBalance(UsrWallet wallet);
	public int saveWalletForIncome(UsrWallet wallet);
	public int saveWalletForCharge(UsrWallet wallet);
	public int saveWalletForDirectPay(UsrWallet wallet);
	public int saveWalletForRefund(UsrWallet wallet);
	public int saveWalletForPay(UsrWallet wallet);

	public void updateForFreeze(UsrWallet wallet);
	public int saveAddGift(UsrWallet wallet, boolean needChangeDeposit);
	/**
	 * 给用户加可用余额
	 * @param usrTransVo
	 * @param sellClient
	 * @param usrOperParam
	 *  @param usrWalletExpandParam 备用扩展参数
	 * @return
	 */
	public UsrWalletLog addAbleBalance(final UsrTransVo usrTransVo, final Integer sellClient, final UsrOperationParam usrOperParam
            , final UsrWalletExpandParam usrWalletExpandParam);
	public UsrWalletLog addAbleBalanceByProvider(final UsrTransVo memberTransVo, final Integer sellClient, final UsrOperationParam userOperParam
            , final UsrWalletExpandParam usrWalletExpandParam);
	/**
	 * 冻结转支付
	 * @param usrTransVo
	 * @param sellClient
	 * @param usrOperParam
	 *  @param usrWalletExpandParam 备用扩展参数
	 * @return
	 */
	public UsrWalletLog subtractFreeze(final WalletLogActualVo walletLogActualVo, final UsrTransVo usrTransVo, final UsrOperationParam usrOperParam
            , final UsrWalletExpandParam usrWalletExpandParam);
	/***
	 * 增加钱包收益
	 * @param actualVo
	 * @param walletId
	 * @param memberTransVo
	 * @param userOperParam
	 * @param usrWalletExpandParam
	 * @return
	 */
	public UsrWalletLog addAbleBalanceForIncome(
            final WalletLogActualVo actualVo,
            final Long walletId,
            final UsrTransVo memberTransVo,
            final UsrOperationParam userOperParam
            , final UsrWalletExpandParam usrWalletExpandParam);

	/**
	 * 为充值加钱包可用金额
	 * @param actualVo
	 * @param walletId
	 * @param usrTransVo
	 * @param sellClient
	 * @param usrOperParam
	 * @param usrWalletExpandParam 备用扩展参数
	 * @return
	 */
	public UsrWalletLog addAbleBalanceForCharge(final WalletLogActualVo actualVo, final Long walletId, final UsrTransVo usrTransVo,
                                                final Integer sellClient, final UsrOperationParam usrOperParam
            , final UsrWalletExpandParam usrWalletExpandParam);

	/**
	 * 退款（支付后退款，冻结转支付后退款）
	 * @param usrTransVo
	 * @param usrOperParam
	 *  @param usrWalletExpandParam 备用扩展参数
	 * @return
	 */
	public UsrWalletLog refund(final UsrTransVo usrTransVo, final UsrOperationParam usrOperParam
            , final UsrWalletExpandParam usrWalletExpandParam);
	/**
   * 为钱包冻结资金
   * 1,彩金和资金的使用规则是先冻结彩金,当彩金不够时,再冻结部分资金
   * 2,冻结金额为实际需要冻结的金额(冻结的彩金+冻结的资金+冻结奖金)
	 * @param usrTransVo
	 * @param firstOption
	 * @param usrOperParam
	 * @param usrWalletExpandParam
	 * @return
	 */
	public UsrWalletLog subtractAbleBalanceAndAddFreeze(final UsrTransVo usrTransVo, final int firstOption,
                                                        final UsrOperationParam usrOperParam, final UsrWalletExpandParam usrWalletExpandParam);
	/**
	 * 用户钱包余额支付
	 * @param firstOption
	 * @param usrTransVo
	 * @param usrOperParam
	 * @return
	 */
	public UsrWalletLog subtractAbleBalance(final int firstOption,
                                            final UsrTransVo usrTransVo, final Integer sellClient, final UsrOperationParam usrOperParam, final UsrWalletExpandParam usrWalletExpandParam);

	/**
	 * 	   * 将冻结转为可用,必须根据一条冻结的钱包流水来操作
		   * 1,解冻时,优先解冻资金
	 * @param walletLogActualVo
	 * @param usrTransVo
	 * @param usrOperParam
	 * @param usrWalletExpandParam
	 * @return
	 */
		public UsrWalletLog subtractFreezeAndAddAbleBalance(final WalletLogActualVo walletLogActualVo, final UsrTransVo usrTransVo, final UsrOperationParam usrOperParam
                , final UsrWalletExpandParam usrWalletExpandParam);

		public void saveUnfreeze(UsrWallet wallet);

	    /**
	     * 异步检查新浪和本地钱包余额，异常发rtx警报通知值班运维技术。
	     * @param userId
	     * @param userType
	     */
	    public void asyncCheckSinaAndLocalWallet(long userId, UserType userType);
	    /***
	     * 解冻 、冻结转支付、退款等，找到相关联的钱包流水
	     * 没有找到抛出异常
	     * @param usrTransVo
	     * @return
	     */
	    public UsrWalletLog getRelatedWalletLogThrowException(UsrTransVo usrTransVo);

	    /***
	     * 添加赠送彩金 并且增加必须消费金额
	     * @param UserType
	     * @param userId
	     * @param transType
	     * @param giftAmount
	     * @param addDeposit
	     * @param giftId
	     * @param giftName
	     * @return
	     */
		public UsrWalletLog addGiftAndAddDeposit(int UserType, long userId, int transType,
                                                 final BigDecimal giftAmount, final BigDecimal addDeposit, final long giftId, final String giftName);

		public UsrWalletLog addGiftAndAddDeposit(int UserType, long userId, int transType,
                                                 final BigDecimal giftAmount, final BigDecimal addDeposit, final long giftId,
                                                 final String giftName, String planNo);

		/**
		 * 根据站点ids查询对应钱包余额
		 * @param providerIds
		 * @return
		 */
		public List<UsrWallet> queryWalletListByProviderIds(List<String> providerIds);

		/**
		 * 查询用户可提款金额
		 * @param userId
		 * @return
		 */
		public AbleGetMoneyVo queryAbleGetMoney(long userId);

		/**
		 * 根据用户类型，查询用户可提款金额
		 *
		 * @param userId
		 * @return
		 */
		public AbleGetMoneyVo queryAbleGetMoneyByUsrType(long userId, Integer userType);


		/**
		 *  用钱包余额支付，只记录流水，不操作钱包
		 * @param memberTransVo
		 * @param userOperParam
		 * @param expandParam
		 * @return
		 */
		public UsrWalletLog subtractAbleBalanceForProvider(int firstOption, UsrTransVo memberTransVo, Integer sellClient,
                                                           UsrOperationParam userOperParam, UsrWalletExpandParam usrWalletExpandParam);
		/**
		 * 给门店直接加钱,操作钱包并添加相应的流水标记,定时器调用
		 * @param actualVo
		 * @param walletId
		 * @param usrTransVo
		 * @param userOperParam
		 * @param usrWalletExpandParam
		 */
		public void addAbleBalanceForProviderDgOperWallet(Long walletId, UsrTransVo usrTransVo,
                                                          UsrOperationParam userOperParam, UsrWalletLogQueryOption condition, int countId);

		/**
		 * 给门店直接派奖扣钱,操作钱包并添加相应的流水标记,定时器调用
		 * @param actualVo
		 * @param walletId
		 * @param usrTransVo
		 * @param userOperParam
		 * @param usrWalletExpandParam
		 */
		public void subtractAbleBalanceForProviderPrizeOperWallet(Long walletId, UsrTransVo usrTransVo,
                                                                  UsrOperationParam userOperParam, UsrWalletLogQueryOption condition, int countId);
}
