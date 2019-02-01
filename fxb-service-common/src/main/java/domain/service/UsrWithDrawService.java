package domain.service;

import domain.entity.*;
import domain.type.WithdrawStatus;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface UsrWithDrawService {

    /**
     * 提款保存接口：保存用户提款信息，用来给财务审核
     *
     * <p>如果 usrWithDraw.getUsrBindCardId()>0 不为空,那么就去UsrBindCard查询相关银行卡数据
     * <p>否则就必须 传递 银行卡相关数据（paymentWay\bankNo\(必填)--bankCode\bankName(原则上 bankName要传,因为前段显示卡时要显示银行名称)--provinces\city\partBank(21家银行外必填)）
     * <p>
     * @param usrWithDraw
     * @param userOperParam   用户操作提款时的IP和版本。。等的信息，userOperParam.getPayPwdReturnUrl(非新浪的提款必传)
     * @return
     */
    public WithdrawResult saveWithDrawInfo(UsrWithDraw usrWithDraw, UsrOperationParam userOperParam);

    /**
     * 第三方（连连支付等）提款通知接口
     * @param thirdWithDrawInformVo
     * @return
     */
    public ModelResult<Boolean> acceptThirdWithDrawInform(ThirdWithDrawInformVo thirdWithDrawInformVo);
}
