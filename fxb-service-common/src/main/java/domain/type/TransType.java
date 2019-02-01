package domain.type;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 交易类型
 * @author zl
 *
 */
public class TransType extends BaseType {
 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1983812081028142997L;
 
 

	public TransType(Integer status, String description) {
		super(status, description);
	}
	
	public TransType(Integer status, String description, String outDescription){
		super(status, description,outDescription);
	}
	/**直付（先充值 再扣款的方式）*/
	public static TransType  CHARGE_ZF = new TransType(9, "直付充值");
	/**会员充值*/
	public static TransType  CHARGE_HY = new TransType(10, "会员充值");
	
	/**兑换充值---彩金*/
	public static TransType  CHARGE_EXCHANGE_CJ = new TransType(11, "兑换充值");
	/**第三方业务彩金赠送*/
    public static TransType  THIRD_CHARGE_CJ = new TransType(12, "迁移活动增加彩金");
	/**彩金赠送*/
    public static TransType  CHARGE_CJ = new TransType(13, "彩金赠送");
    /**其他退款*/
	public static TransType  CHARGE_TK = new TransType(14, "其他退款");
    /**其它加款*/
	public static TransType  CHARGE_OTHER = new TransType(15, "其它加款");
    /**后台根据订单补单*/
	public static TransType  CHARGE_BD = new TransType(16, "补单充值");
    /**返奖*/
	public static TransType  RETURN_PRIZE = new TransType(17, "返奖收入");
    /**本应是提款转支付后退款退款,但是admin没有关联转支付,只能作为直接加款*/
	public static TransType  PAY_BACK_GET_MONEY = new TransType(18, "提款退款");
	
	/**追号撤销退款(需要根据追号计划支付的流水，进行退款)*/
	public static TransType  PAY_BACK_ZH = new TransType(19, "追号代购退款");
	
	/***
	 * 爱刮刮支付退款
	 */
	public static TransType RETURN_AIGUAGUA = new TransType(20, "爱刮刮退款");
	
	/**追号计划冻结*/
	public static TransType  FREEZE_ZH = new TransType(21, "追号冻结");
    /**提款冻结*/
	public static TransType  FREEZE_TK = new TransType(24, "提款冻结");
    /**代购冻结*/
	public static TransType  FREEZE_DG = new TransType(25, "代购冻结");
    /** 损益资金冻结 */
	public static TransType  FREEZE_EXCEPTION = new TransType(27, "损益资金冻结");
	/***站点返奖冻结*/
	public static TransType  FREEZE_PRIZE = new TransType(28, "返奖冻结");

	public static TransType FREEZE_MIGRATION = new TransType(29, "迁移冻结");
	
	/**追号计划解冻*/
	public static TransType  UNFREEZE_JH_ZH = new TransType(30, "追号计划解冻");
	/**追号彩期解冻*/
	public static TransType  UNFREEZE_ZH = new TransType(31, "追号彩期解冻");
    /**提款解冻*/
	public static TransType  UNFREEZE_TK = new TransType(34, "提款解冻");
	public static TransType  UNFREEZE_DG = new TransType(35, "代购解冻");
    /** 损益资金解冻 */
	public static TransType  UNFREEZE_EXCEPTION = new TransType(37, "损益资金解冻");
	 /** 站点返奖解冻 */
	public static TransType  UNFREEZE_PRIZE = new TransType(38, "返奖解冻");

	public static TransType  UNFREEZE_MIGRATION = new TransType(39, "迁移解冻");

    /** 代购支付,是冻结之后转支付*/
	public static TransType  PAY_DG = new TransType(40, "代购支付");
	/**追号计划冻结 转支付*/
	public static TransType  PAY_ZH = new TransType(41, "追号冻结转支付");

	public static TransType PAY_MIGRATION = new TransType(42, "迁移冻结转支付");

	public static TransType PAY_AIGUAGUA = new TransType(43, "爱刮刮支付");
	/***
	 * 爱刮刮对公账户返奖支付
	 */
	public static TransType PAY_PRIZE_PUBLIC_AIGUAGUA = new TransType(44, "爱刮刮对公账户-支付");
	/***
	 * 爱刮刮对公账户-收入退回
	 */
	public static TransType PAY_REFUND_PUBLIC_AIGUAGUA = new TransType(45, "爱刮刮对公账户-退回");
	
    /**提款冻结转支付*/
	public static TransType  PAY_TK = new TransType(46, "提款支付");
    /** 损益资金支付,是冻结之后转支付*/
	public static TransType  PAY_EXCEPTION = new TransType(47, "损益资金支付");
	/**回购支付*/
	public static TransType  PAY_REPO = new TransType(48, "回购支付");
	/** 部分出票退款支付 */
	public static TransType PAY_PART_TICKET = new TransType(49, "部分出票退款支付");
	
	/***跟投发单红包支付*/
	public static TransType  PAY_GT_RED = new TransType(50, "跟投发单红包支付");
	
	/**跟投领取红包收入*/
	public static TransType  ADD_GT_RED = new TransType(51, "跟投领取红包收入");
 
    /** 代购退款*/
	public static TransType  TK_DG = new TransType(52, "代购退款");

	 /** 合作方返奖*/
	public static TransType  ADD_PRIZE_AIGUAGUA = new TransType(53, "爱刮刮返奖");
 
    /**系统（分出是后台人工退）追号退款*/
	public static TransType  TK_DG_ADMIN = new TransType(54, "系统代购退款");
	/**抵扣券退款*/
	public static TransType  TK_REBATE = new TransType(55, "抵扣券退款");
	
	/**跟投发单红包退款*/
	public static TransType  TK_GT_RED = new TransType(56, "跟投发单红包退款");
	
	/**跟投打赏支付*/
	public static TransType  PAY_GT_TIP = new TransType(57, "打赏支付");
	
	/**跟投打赏收入*/
	public static TransType  ADD_GT_TIP = new TransType(58, "打赏收入");
	
	/***
	 * 爱刮刮对公账户支付收入
	 */
	public static TransType ADD_PUBLIC_AIGUAGUA = new TransType(59, "爱刮刮对公账户-收入");
	
   
    /**损益资金扣款,不经过冻结*/
	public static TransType  EXCEPTION_KK = new TransType(61, "损益资金直接扣款");
	/**抵扣券扣款,不经过冻结*/
	public static TransType  REBATE_KK = new TransType(65, "抵扣券直接扣款");
 
    /**彩金赠送扣款*/
    public static TransType  ADD_GIFT_AMOUNT_KK = new TransType(66, "彩金赠送扣款");
 
    public static TransType PAY_ABLANCE_TO_GIFT = new TransType(67, "现金转彩金支付");
    /***彩金转现金-（有些用户强烈要求提款）*/
    public static TransType PAY_GIFT_TO_ABLANCE = new TransType(68, "彩金转现金支付");

    /** 多米智投方案分成 */
    public static TransType DUO_MI_ZHI_TOU_INCOME = new TransType(69, "多米智投分成");
    
    /**增加最低消费 = new CopyOfTransType(一般由于营销活动引用)*/
	public static TransType  ADD_DEPOSIT = new TransType(70, "增加最低消费");
 
	/**损益资金奖金加款*/
	public static TransType  ADD_PRIZE_EXCEPTION = new TransType(71, "损益奖金加款");
	/** 补派奖金收入 */
	public static TransType  ADD_PRIZE = new TransType(72,"补派奖金收入");
    
    /**损益资金现金加款*/
	public static TransType  ADD_EXCEPTION = new TransType(73, "损益现金加款");
	/**增加彩金*/
	public static TransType  ADD_ABLANCE_TO_GIFT = new TransType(74, "现金转彩金收入");
	/***彩金转现金-（有些用户强烈要求提款）   增加现金*/
	public static TransType  ADD_GIFT_TO_ABLANCE = new TransType(75, "彩金转现金收入");
	/**损益资金彩金加款*/
	public static TransType  ADD_GIFT_EXCEPTION = new TransType(76, "损益彩金加款");
	/**回购订单返奖收入*/
	public static TransType HG_RETURN_PRIZE = new TransType(77, "回购返奖收入");
	/**赢家分成返奖*/
	public static TransType GT_INCOME_PRIZE = new TransType(78, "赢家分成返奖收入");
	/** 部分出票退款收入 */
	public static TransType ADD_PART_TICKET = new TransType(79, "部分出票退款收入");
	/** 代领奖收入 */
	public static TransType ADD_AGENT_RECEIVE_PRIZE = new TransType(80, "代领奖收入");
	/** 代派奖支付 */
	public static TransType PAY_AGENT_PAYOUT_PRIZE = new TransType(81, "代派奖支付");
	/** 代派奖收入  */
	public static TransType ADD_AGENT_PAYOUT_PRIZE = new TransType(82, "代派奖收入");
	/** 部分出票代收 */
	public static TransType ADD_PART_TICKET_PAYIN = new TransType(83, "部分出票代收");
	/** 部分出票代付支付 */
	public static TransType PAY_PART_TICKET_PAYOUT = new TransType(84, "部分出票代付支付");
	/** 部分出票代付收入  */
	public static TransType ADD_PART_TICKET_PAYOUT = new TransType(85, "部分出票代付收入");
	/** 补派奖代收 */
	public static TransType ADD_ADDITIONAL_PRIZE_PAYIN = new TransType(86, "补派奖代收");
	/** 补派奖代付支付 */
	public static TransType PAY_ADDITIONAL_PRIZE_PAYOUT = new TransType(87, "补派奖代付支付");
	/** 补派奖代付收入  */
	public static TransType ADD_ADDITIONAL_PRIZE_PAYOUT = new TransType(88, "补派奖代付收入");
	
	/** 活动赠送彩金-代收 */
	public static TransType ADD_ZS_GIFT_AMOUNT_PAYIN = new TransType(89, "活动赠送彩金代收");
	/** 活动赠送彩金-支付 */
	public static TransType PAY_ZS_GIFT_AMOUNT_PAYOUT = new TransType(90, "活动赠送彩金代付支付");
	/** 活动赠送彩金-收入  */
	public static TransType ADD_ZS_GIFT_AMOUNT_PAYOUT = new TransType(91, "活动赠送彩金代付收入");
	
    /**增加现金余额,第三方直付退款*/
	public static TransType  ADD_THIRD_DIRECT_TK = new TransType(92, "第三方直付退款");
	
	
    public static TransType RETURN_PAY_PRIZE = new TransType(100, "派奖返还");
	public static TransType DEDUCTED_PRIZE = new TransType(101, "奖金扣回");
	public static TransType DEDUCTED_GT_INCOME = new TransType(102, "赢家分成扣回");
	public static TransType DEDUCTED_DMZT_INCOME = new TransType(103, "多米智投分成扣回");
	public static TransType DEDUCTED_HG_PRIZE = new TransType(104, "回购返奖扣回");
	public static TransType REDO_PAY_PRIZE = new TransType(105, "重派奖支付");
	public static TransType REDO_RETURN_PRIZE = new TransType(106, "重派奖收入");
	public static TransType REDO_GT_INCOME_PRIZE = new TransType(107, "重派赢家分成收入");
	public static TransType REDO_DMTZ_INCOME_PRIZE = new TransType(108, "重派多米智投分成收入");
	public static TransType REDO_HG_PRIZE = new TransType(109, "重派回购返奖收入");

	public static TransType INCOME = new TransType(110,"存钱罐收益");
	
	public static TransType STOP_SALL_FREEZE_TK = new TransType(111, "赠送彩金提款冻结");
	public static TransType STOP_SALL_UNFREEZE_TK  = new TransType(112, "赠送彩金提款解冻");
	public static TransType STOP_SALL_PAY_TK = new TransType(113, "赠送彩金提款冻结转支付");
	/** 补派奖金支付 */
	public static TransType  SUBTRACT_PRIZE = new TransType(114,"补派奖金支付");
    /***
     * 返奖支付-冻结转支付
     */
    public static TransType  PAY_PRIZE = new TransType(120, "返奖支付");

    public static TransType  ADD_DG = new TransType(121, "代购收入");
    
    public static TransType  PAY_COMMISSION = new TransType(122, "佣金支付");
   
    
    public static TransType  HG_INCOME = new TransType(126, "回购收入");

    
    
    /***
    * 
    * >126 有判断问题, 先在前面加类型
    * 
    */
    /**借还款作废,由于已经有代码引入 先@Deprecated*/
    @Deprecated
    public static TransType  JK_PAY = new TransType(0, "借款支付");
    @Deprecated
    public static TransType  JK_INCOME = new TransType(0, "借款收入");
    @Deprecated
    public static TransType  HK_PAY = new TransType(0, "还款支付");
    @Deprecated
    public static TransType  HK_INCOME = new TransType(0, "还款收入");
 
    public static List<TransType> getAll() {
   		return getAll(TransType.class);
    }

    /**
     * 后台根据订单补单
     * @return
     * @create_time 2011-2-17 下午05:18:31
     */
    public static List<TransType> getBDTransType() {
        return Arrays.asList(new TransType[] {  CHARGE_BD });
    }

    /**是否收入交易类型*/
    public static boolean isIncomeType(TransType type) {
        List<TransType> incomeTypeList = getIncomeTypeList();
        if (incomeTypeList.contains(type)) {
            return true;
        }
        return false;
    }

    /**是否支出交易类型*/
    public static boolean isOutcomeType(TransType type) {
        List<TransType> outcomeTypeList = getOutcomeTypeList();
        if (outcomeTypeList.contains(type)) {
            return true;
        }
        return false;
    }

    /**
     * 收入交易类型
     * @return
     * @create_time 2011-2-22 上午11:55:18
     */
    public static List<TransType> getIncomeTypeList() {
        List<TransType> incomeTypeList = new ArrayList<TransType>();
        
        incomeTypeList.add(TransType.CHARGE_ZF);
        incomeTypeList.add(TransType.CHARGE_HY);
        incomeTypeList.add(TransType.CHARGE_CJ);
        incomeTypeList.add(TransType.CHARGE_EXCHANGE_CJ);
        incomeTypeList.add(TransType.THIRD_CHARGE_CJ);
        
        
        incomeTypeList.add(TransType.CHARGE_TK);
        incomeTypeList.add(TransType.CHARGE_OTHER);
        incomeTypeList.add(TransType.CHARGE_BD);
        incomeTypeList.add(TransType.RETURN_PRIZE);
        incomeTypeList.add(TransType.REDO_RETURN_PRIZE);
        incomeTypeList.add(TransType.ADD_AGENT_RECEIVE_PRIZE);
        incomeTypeList.add(TransType.ADD_AGENT_PAYOUT_PRIZE);
        incomeTypeList.add(TransType.ADD_ADDITIONAL_PRIZE_PAYIN);
        incomeTypeList.add(TransType.ADD_ZS_GIFT_AMOUNT_PAYIN);
        
        incomeTypeList.add(TransType.ADD_ADDITIONAL_PRIZE_PAYOUT);
        incomeTypeList.add(TransType.HG_RETURN_PRIZE);
        incomeTypeList.add(TransType.REDO_HG_PRIZE);
        incomeTypeList.add(TransType.DUO_MI_ZHI_TOU_INCOME);
        incomeTypeList.add(TransType.REDO_DMTZ_INCOME_PRIZE);
        incomeTypeList.add(TransType.GT_INCOME_PRIZE);
        incomeTypeList.add(TransType.REDO_GT_INCOME_PRIZE);
        incomeTypeList.add(TransType.HG_INCOME);
 
        incomeTypeList.add(TransType.ADD_PRIZE);

        incomeTypeList.add(TransType.TK_DG_ADMIN);
 
        incomeTypeList.add(TransType.TK_DG);
        incomeTypeList.add(TransType.RETURN_AIGUAGUA);
        
        incomeTypeList.add(TransType.TK_REBATE);
        

        incomeTypeList.add(TransType.PAY_BACK_GET_MONEY);
        incomeTypeList.add(TransType.PAY_BACK_ZH);
        
        //异常资金加款
        incomeTypeList.add(TransType.ADD_EXCEPTION);
        incomeTypeList.add(TransType.ADD_PRIZE_EXCEPTION);
        incomeTypeList.add(TransType.ADD_GIFT_EXCEPTION);

        // 奖金返还
        incomeTypeList.add(TransType.RETURN_PAY_PRIZE);

        //站点端
        incomeTypeList.add(TransType.ADD_DG);

        incomeTypeList.add(TransType.JK_INCOME);
        incomeTypeList.add(TransType.HK_INCOME); 
        
        incomeTypeList.add(TransType.ADD_ABLANCE_TO_GIFT);
        incomeTypeList.add(TransType.ADD_GIFT_TO_ABLANCE);
        
        incomeTypeList.add(TransType.ADD_PART_TICKET);
        incomeTypeList.add(TransType.ADD_PART_TICKET_PAYOUT);
        incomeTypeList.add(TransType.ADD_PART_TICKET_PAYIN);
        
        incomeTypeList.add(TransType.ADD_THIRD_DIRECT_TK);
        return incomeTypeList;
    }

    /**
     * 支出交易类型(从所有交易类型排除收入交易类型不一定都是支出交易类型)
     * @return
     * @create_time 2011-2-22 上午11:55:09
     */
    public static List<TransType> getOutcomeTypeList() {
        List<TransType> outcomeTypeList = new ArrayList<TransType>();
        outcomeTypeList.add(TransType.PAY_DG);
        outcomeTypeList.add(TransType.PAY_ZH);

        outcomeTypeList.add(TransType.PAY_EXCEPTION);

        outcomeTypeList.add(TransType.PAY_MIGRATION);

        outcomeTypeList.add(TransType.PAY_TK);
        outcomeTypeList.add(TransType.STOP_SALL_PAY_TK);
        //站点端
        outcomeTypeList.add(TransType.PAY_PRIZE);
        outcomeTypeList.add(TransType.SUBTRACT_PRIZE);
        
        //站点佣金支付
        outcomeTypeList.add(TransType.PAY_COMMISSION);
        outcomeTypeList.add(TransType.REDO_PAY_PRIZE);
        outcomeTypeList.add(TransType.EXCEPTION_KK);
        outcomeTypeList.add(TransType.DEDUCTED_PRIZE);
        outcomeTypeList.add(TransType.DEDUCTED_GT_INCOME);
        outcomeTypeList.add(TransType.DEDUCTED_DMZT_INCOME);
        outcomeTypeList.add(TransType.DEDUCTED_HG_PRIZE);

        outcomeTypeList.add(TransType.PAY_AGENT_PAYOUT_PRIZE);
        outcomeTypeList.add(TransType.PAY_ADDITIONAL_PRIZE_PAYOUT);
        outcomeTypeList.add(TransType.REBATE_KK);
        outcomeTypeList.add(TransType.ADD_GIFT_AMOUNT_KK);
        
        outcomeTypeList.add(TransType.PAY_REPO);
        outcomeTypeList.add(TransType.PAY_AIGUAGUA);
        outcomeTypeList.add(TransType.PAY_PRIZE_PUBLIC_AIGUAGUA);
        outcomeTypeList.add(TransType.PAY_REFUND_PUBLIC_AIGUAGUA);
        
        
        outcomeTypeList.add(TransType.PAY_PART_TICKET);
        outcomeTypeList.add(TransType.PAY_PART_TICKET_PAYOUT);
        outcomeTypeList.add(TransType.PAY_ZS_GIFT_AMOUNT_PAYOUT);
        
        outcomeTypeList.add(TransType.JK_PAY);
        outcomeTypeList.add(TransType.HK_PAY); 
        
        outcomeTypeList.add(TransType.PAY_ABLANCE_TO_GIFT);
        outcomeTypeList.add(TransType.PAY_GIFT_TO_ABLANCE);
        

       
        return outcomeTypeList;
    }

    /**
     * 可以显示订单的交易类型
     * @return
     * @create_time 2011-2-22 上午11:55:38
     */
    public static List<TransType> getOrderTypeList() {
        List<TransType> list = new ArrayList<TransType>();
        list.add(TransType.CHARGE_CJ);
     
        /**返奖*/
        list.add(TransType.RETURN_PRIZE);
        list.add(TransType.REDO_RETURN_PRIZE);
        list.add(TransType.ADD_AGENT_RECEIVE_PRIZE);
        list.add(TransType.ADD_AGENT_PAYOUT_PRIZE);
        list.add(TransType.ADD_ADDITIONAL_PRIZE_PAYIN);
        list.add(TransType.ADD_ADDITIONAL_PRIZE_PAYOUT);
        list.add(TransType.HG_RETURN_PRIZE);
        list.add(TransType.REDO_HG_PRIZE);
        list.add(TransType.DUO_MI_ZHI_TOU_INCOME);
        list.add(TransType.REDO_DMTZ_INCOME_PRIZE);
        list.add(TransType.GT_INCOME_PRIZE);
        list.add(TransType.REDO_GT_INCOME_PRIZE);
        list.add(TransType.ADD_PRIZE);
        /**代购支付*/
        list.add(TransType.PAY_DG);
        list.add(TransType.PAY_ZH);
        
        /**回购*/
        list.add(TransType.HG_INCOME);
        list.add(TransType.PAY_REPO);
        list.add(TransType.PAY_AIGUAGUA);
        list.add(TransType.PAY_PRIZE_PUBLIC_AIGUAGUA);
        list.add(TransType.PAY_REFUND_PUBLIC_AIGUAGUA);
        
        list.add(TransType.PAY_PART_TICKET);
        
        list.add(TransType.ADD_PART_TICKET);
        
        list.add(TransType.ADD_PART_TICKET_PAYOUT);
        list.add(TransType.ADD_PART_TICKET_PAYIN);
        
        


        return list;
    }

  
   
    
    /**
     * 直接支付列表,减少可用余额
     * @return
     */
    public static List<Integer> getDirectePayList(){
    	 List<Integer> list = new ArrayList<Integer>();
    	 // 站点
    	 list.add(PAY_PRIZE.getIndex());
    	 list.add(SUBTRACT_PRIZE.getIndex());

    	 //站点佣金支付
    	 list.add(PAY_COMMISSION.getIndex());
    	 
    	 list.add(REDO_PAY_PRIZE.getIndex());
    	 list.add(TransType.EXCEPTION_KK.getIndex());
    	 list.add(TransType.DEDUCTED_PRIZE.getIndex());
    	 list.add(TransType.DEDUCTED_GT_INCOME.getIndex());
    	 list.add(TransType.DEDUCTED_DMZT_INCOME.getIndex());
    	 list.add(TransType.DEDUCTED_HG_PRIZE.getIndex());

    	 list.add(TransType.PAY_AGENT_PAYOUT_PRIZE.getIndex());
    	 list.add(TransType.PAY_ADDITIONAL_PRIZE_PAYOUT.getIndex());
    	 list.add(TransType.REBATE_KK.getIndex());
    	 list.add(TransType.ADD_GIFT_AMOUNT_KK.getIndex());
    	 
    	 list.add(TransType.JK_PAY.getIndex());
    	 list.add(TransType.HK_PAY.getIndex());
    	 list.add(TransType.PAY_ABLANCE_TO_GIFT.getIndex());
    	 list.add(TransType.PAY_GIFT_TO_ABLANCE.getIndex());
    	 list.add(TransType.PAY_REPO.getIndex());
    	 list.add(TransType.PAY_AIGUAGUA.getIndex());
         list.add(TransType.PAY_PRIZE_PUBLIC_AIGUAGUA.getIndex());
         list.add(TransType.PAY_REFUND_PUBLIC_AIGUAGUA.getIndex());
    	 
    	 list.add(TransType.PAY_PART_TICKET.getIndex());
    	 list.add(TransType.PAY_PART_TICKET_PAYOUT.getIndex());
    	 list.add(TransType.PAY_ZS_GIFT_AMOUNT_PAYOUT.getIndex());
    	 list.add(TransType.PAY_GT_RED.getIndex());
    	 list.add(TransType.PAY_GT_TIP.getIndex());
    	 return list;
    }
    
    
    
    /**
     * 冻结列表，减少可用余额，同时增加冻结余额
     * @return
     */
    public static List<Integer> getFreezeList(){
    	 List<Integer> list = new ArrayList<Integer>();
    	
    	 list.add(FREEZE_TK.getIndex());
    	 
    	 list.add(STOP_SALL_FREEZE_TK.getIndex());
    	 list.add(FREEZE_EXCEPTION.getIndex());

        list.add(FREEZE_MIGRATION.getIndex());

        list.add(FREEZE_DG.getIndex());
        list.add(FREEZE_ZH.getIndex());

        list.add(FREEZE_PRIZE.getIndex());


    	 return list;
    }
    /**
     * 充值的，增加可用现金余额
     */
    public static List<Integer> getChargList(){   
     List<Integer> list = new ArrayList<Integer>();
   	 list.add(CHARGE_HY.getIndex());
   	 list.add(CHARGE_BD.getIndex());
   	 return list;
        
    }
    
    public static List<Integer> getAddCashList(){
    	List<Integer> list = new ArrayList<Integer>();
    	 list.add(CHARGE_TK.getIndex());
    	 list.add(ADD_DG.getIndex());

         //异常资金加款
        list.add(ADD_EXCEPTION.getIndex());
        list.add(RETURN_PAY_PRIZE.getIndex());

    	 list.add(TransType.JK_INCOME.getIndex());
    	 list.add(TransType.HK_INCOME.getIndex()); 
    	 
    	 list.add(TransType.ADD_GIFT_TO_ABLANCE.getIndex());
    	 
    	 list.add(ADD_PART_TICKET.getIndex());
         list.add(ADD_PART_TICKET_PAYOUT.getIndex());
         list.add(ADD_PART_TICKET_PAYIN.getIndex());
         
         list.add(ADD_THIRD_DIRECT_TK.getIndex());
         
         list.add(CHARGE_ZF.getIndex());
         
         list.add(ADD_PUBLIC_AIGUAGUA.getIndex());
         
         
         
    	 return list;
    }
    
    public static List<Integer> getAddIncomeList(){
    	 List<Integer> list = new ArrayList<Integer>();
    	 list.add(INCOME.getIndex());
    	 return list;
    }
    /**
     * 直接增加可用奖金，增加可用余额
     */
    public static List<Integer> getAddPrizeList(){
    	 List<Integer> list = new ArrayList<Integer>();
    	 list.add(CHARGE_OTHER.getIndex());
    	 list.add(ADD_PRIZE.getIndex());
    	 list.add(RETURN_PRIZE.getIndex());
    	 list.add(REDO_RETURN_PRIZE.getIndex());
    	 list.add(ADD_AGENT_RECEIVE_PRIZE.getIndex());
    	 list.add(ADD_AGENT_PAYOUT_PRIZE.getIndex());
    	 list.add(ADD_ADDITIONAL_PRIZE_PAYIN.getIndex());
    	 list.add(ADD_ADDITIONAL_PRIZE_PAYOUT.getIndex());
    	 list.add(HG_RETURN_PRIZE.getIndex());
    	 list.add(REDO_HG_PRIZE.getIndex());
    	 list.add(DUO_MI_ZHI_TOU_INCOME.getIndex());
    	 list.add(REDO_DMTZ_INCOME_PRIZE.getIndex());
    	 list.add(GT_INCOME_PRIZE.getIndex());
    	 list.add(REDO_GT_INCOME_PRIZE.getIndex());
    	 list.add(PAY_BACK_GET_MONEY.getIndex());//这个放在直接加钱给他
    	 list.add(HG_INCOME.getIndex());  //回购收入已奖金形式给用户
    	 
    	 list.add(ADD_PRIZE_EXCEPTION.getIndex());
    	 
    	 list.add(ADD_PRIZE_AIGUAGUA.getIndex());
    	 
    	 
    	 return list;
    	
    }
    
    /**
     * 直接加钱到用户钱包可用彩金，增加可用余额
     * @return
     */
    public static List<Integer> getAddGiftList(){
    	List<Integer> list = new ArrayList<Integer>();
    	list.add(CHARGE_CJ.getIndex());
    	list.add(ADD_ABLANCE_TO_GIFT.getIndex());
    	list.add(CHARGE_EXCHANGE_CJ.getIndex());
    	list.add(ADD_GIFT_EXCEPTION.getIndex());
    	list.add(TransType.THIRD_CHARGE_CJ.getIndex());
    	
    	list.add(TransType.ADD_ZS_GIFT_AMOUNT_PAYIN.getIndex());
    	list.add(TransType.ADD_ZS_GIFT_AMOUNT_PAYOUT.getIndex());
    	
    	list.add(ADD_GT_RED.getIndex());
    	list.add(ADD_GT_TIP.getIndex());
    	return list;
    }
    /**
     * 解冻列表，减少冻结余额，增加可用余额
     * @return
     */
    public static List<Integer> getUnFreezeList(){
    	List<Integer> list = new ArrayList<Integer>();
    	list.add(UNFREEZE_TK.getIndex());
    	list.add(STOP_SALL_UNFREEZE_TK.getIndex());
    	list.add(UNFREEZE_EXCEPTION.getIndex());
    	list.add(UNFREEZE_DG.getIndex());
    	list.add(UNFREEZE_ZH.getIndex());
    	list.add(UNFREEZE_JH_ZH.getIndex());

    	list.add(UNFREEZE_PRIZE.getIndex());
    	list.add(UNFREEZE_MIGRATION.getIndex());

   	 return list;
    }
    /**
     * 冻结转支付列表，减少冻结余额
     * @return
     */
    public static List<Integer> getTransferPayList(){
    	List<Integer> list = new ArrayList<Integer>();  	 
    	list.add(PAY_TK.getIndex());
    	list.add(STOP_SALL_PAY_TK.getIndex());
    	list.add(PAY_EXCEPTION.getIndex());

        list.add(PAY_MIGRATION.getIndex());
        list.add(PAY_DG.getIndex());
        // list.add(PAY_PRIZE.getIndex());
    	
    	list.add(PAY_ZH.getIndex());
   	 return list;
    }
    /**
     * 直接支付后退款的列表，增加可用余额
     * @return
     */
    public static List<Integer> getRefundForDirectePayList(){
    	List<Integer> list = new ArrayList<Integer>();
    	list.add(TK_DG_ADMIN.getIndex());
    	list.add(TransType.TK_REBATE.getIndex());
    	list.add(TransType.TK_GT_RED.getIndex());
 
    	
    	list.add(TransType.RETURN_AIGUAGUA.getIndex());
   	 return list;
    }
    /**
     * 冻结转支付后退款的列表，增加可用余额
     * @return
     */
    public static List<Integer> getRefundForTransferPayList(){
    	List<Integer> list = new ArrayList<Integer>();
    	list.add(TK_DG.getIndex());
    	list.add(TransType.PAY_BACK_ZH.getIndex());
   	 	return list;
    }
    /**
     * 不需要处理Deposit 的交易列表
     */ 
    public static List<Integer> getNotNeedDepositList(){
    	List<Integer> list = new ArrayList<Integer>();
    	
    	list.add(ADD_GIFT_EXCEPTION.getIndex());
    	list.add(CHARGE_CJ.getIndex());
    	list.add(CHARGE_EXCHANGE_CJ.getIndex());
    	list.add(TransType.THIRD_CHARGE_CJ.getIndex());
    	
    	list.add(CHARGE_TK.getIndex());
    	list.add(CHARGE_OTHER.getIndex());
    	list.add(RETURN_PRIZE.getIndex());
    	list.add(REDO_RETURN_PRIZE.getIndex());
    	list.add(ADD_AGENT_RECEIVE_PRIZE.getIndex());
    	list.add(ADD_AGENT_PAYOUT_PRIZE.getIndex());
    	list.add(ADD_ADDITIONAL_PRIZE_PAYIN.getIndex());
    	list.add(ADD_ADDITIONAL_PRIZE_PAYOUT.getIndex());
    	list.add(HG_RETURN_PRIZE.getIndex());
    	list.add(REDO_HG_PRIZE.getIndex());
    	list.add(DUO_MI_ZHI_TOU_INCOME.getIndex());
    	list.add(REDO_DMTZ_INCOME_PRIZE.getIndex());
    	list.add(GT_INCOME_PRIZE.getIndex());
    	list.add(REDO_GT_INCOME_PRIZE.getIndex());
    	list.add(HG_INCOME.getIndex());
    	
 
    	list.add(PAY_BACK_GET_MONEY.getIndex());
    	list.add(PAY_BACK_ZH.getIndex());
    	
    	
    	list.add(FREEZE_TK.getIndex());
    	list.add(STOP_SALL_FREEZE_TK.getIndex());
    	list.add(FREEZE_EXCEPTION.getIndex());

        list.add(FREEZE_MIGRATION.getIndex());

        list.add(UNFREEZE_TK.getIndex());
        list.add(STOP_SALL_UNFREEZE_TK.getIndex());
        list.add(UNFREEZE_EXCEPTION.getIndex());

        list.add(UNFREEZE_MIGRATION.getIndex());


        list.add(PAY_TK.getIndex());
        list.add(STOP_SALL_PAY_TK.getIndex());
    	// 站点
    	list.add(PAY_PRIZE.getIndex());
    	list.add(SUBTRACT_PRIZE.getIndex());
    	
    	//站点佣金支付
    	list.add(PAY_COMMISSION.getIndex());
    	list.add(REDO_PAY_PRIZE.getIndex());
    	list.add(EXCEPTION_KK.getIndex());
    	list.add(DEDUCTED_PRIZE.getIndex());
    	list.add(DEDUCTED_GT_INCOME.getIndex());
    	list.add(DEDUCTED_DMZT_INCOME.getIndex());
    	list.add(DEDUCTED_HG_PRIZE.getIndex());

    	list.add(PAY_AGENT_PAYOUT_PRIZE.getIndex());
    	list.add(PAY_ADDITIONAL_PRIZE_PAYOUT.getIndex());
    	list.add(REBATE_KK.getIndex());
    	list.add(ADD_GIFT_AMOUNT_KK.getIndex());
 
    	list.add(ADD_PRIZE.getIndex());
    	list.add(ADD_PRIZE_AIGUAGUA.getIndex());
    	
    	
 
    	list.add(UNFREEZE_PRIZE.getIndex());
    	list.add(FREEZE_PRIZE.getIndex());
    	
        //异常资金加款
    	list.add(ADD_EXCEPTION.getIndex());
    	list.add(ADD_PRIZE_EXCEPTION.getIndex());
    	list.add(RETURN_PAY_PRIZE.getIndex());

    	
    	/**** 代购冻结 和 解冻 恢复使用必须消费金额
    	list.add(FREEZE_DG.getIndex());
    	list.add(UNFREEZE_DG.getIndex());
    	*/
    	list.add(ADD_ABLANCE_TO_GIFT.getIndex());
    	list.add(PAY_ABLANCE_TO_GIFT.getIndex());
    	
    	list.add(ADD_GIFT_TO_ABLANCE.getIndex());
    	list.add(PAY_GIFT_TO_ABLANCE.getIndex());
    	
    	list.add(ADD_PART_TICKET.getIndex());
        list.add(ADD_PART_TICKET_PAYOUT.getIndex());
        list.add(ADD_PART_TICKET_PAYIN.getIndex());
        
        list.add(ADD_PUBLIC_AIGUAGUA.getIndex());
    	
    	return list;
    }
    /**
     * 需要处理HeapPrize 的交易列表
     * @return
     */
    public static List<Integer> getNeedHeapPrizeList(){
    	List<Integer> list = new ArrayList<Integer>();
    	list.add(RETURN_PRIZE.getIndex());
    	list.add(REDO_RETURN_PRIZE.getIndex());
    	list.add(ADD_AGENT_RECEIVE_PRIZE.getIndex());
    	list.add(ADD_AGENT_PAYOUT_PRIZE.getIndex());
    	list.add(ADD_ADDITIONAL_PRIZE_PAYIN.getIndex());
    	list.add(ADD_ADDITIONAL_PRIZE_PAYOUT.getIndex());
    	list.add(HG_RETURN_PRIZE.getIndex());
    	list.add(REDO_HG_PRIZE.getIndex());
    	list.add(DUO_MI_ZHI_TOU_INCOME.getIndex());
    	list.add(REDO_DMTZ_INCOME_PRIZE.getIndex());
    	list.add(GT_INCOME_PRIZE.getIndex());
    	list.add(REDO_GT_INCOME_PRIZE.getIndex());
    	list.add(HG_INCOME.getIndex());
    	list.add(ADD_PRIZE.getIndex());
    	list.add(ADD_PRIZE_AIGUAGUA.getIndex());
    	
    	return list;
    }
    /**
     * 需要处理HeapIncome 的交易列表
     * @return
     */
    public static List<Integer> getNeedHeapIncomeList(){
    	List<Integer> list = new ArrayList<Integer>();
    	list.add(INCOME.getIndex());
    	return list;
    }
    /**
     * 需要处理HeapGift 交易列表
     * @return
     */
    public static List<Integer> getNeedHeapGiftList(){
    	List<Integer> list = new ArrayList<Integer>();
    	list.add(TransType.THIRD_CHARGE_CJ.getIndex());
    	list.add(CHARGE_CJ.getIndex());
    	list.add(CHARGE_EXCHANGE_CJ.getIndex());
    	list.add(ADD_GIFT_EXCEPTION.getIndex());
    	
    	return list;
    }
    /**
     * 需要处理HeapBalance的交易列表
     * @return
     */
    public static List<Integer> getNeedHeapBalanceList(){
    	List<Integer> list = new ArrayList<Integer>();
    	list.add(PAY_DG.getIndex());
    	list.add(PAY_ZH.getIndex());
    	list.add(TK_DG.getIndex());
    	list.add(TK_DG_ADMIN.getIndex());
      	list.add(TK_REBATE.getIndex());
    	//站点
    	// list.add(PAY_PRIZE.getIndex());
    	//回购支付
    	list.add(PAY_REPO.getIndex());
    	list.add(PAY_AIGUAGUA.getIndex());
        list.add(TransType.PAY_PRIZE_PUBLIC_AIGUAGUA.getIndex());
        list.add(TransType.PAY_REFUND_PUBLIC_AIGUAGUA.getIndex());
    	
    	
    	list.add(PAY_PART_TICKET.getIndex());
    	list.add(PAY_PART_TICKET_PAYOUT.getIndex());
    	list.add(PAY_ZS_GIFT_AMOUNT_PAYOUT.getIndex());
    	
    	
	   	list.add(TransType.JK_PAY.getIndex());
	   	list.add(TransType.HK_PAY.getIndex()); 
    	return list;
    }
   	public static  TransType valueOf(Integer index){
   		return valueOf(TransType.class, index);
   	}
   	public static  TransType findByIndex(Integer index){
   		return valueOf(TransType.class, index);
   	}
   	
  

}
