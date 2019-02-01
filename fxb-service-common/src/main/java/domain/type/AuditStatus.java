package domain.type;

import java.util.List;

/**
 * 提款状态
 * @author ming.chen
 * 只有是0审核中的  才能进行审核
 * 
 * 2016-5-17增加 4初始化状态，因为初始化状态是不能被审核的,只有审核中的数据才能被审核
 * 1、通过第三方提款的-申请之后为初始化-> 等新浪代收成功 -> 才改成审核中     
 * 2、新浪提款-申请之后-> 就是审核中
 *
 */
public class AuditStatus extends BaseType {
	private static final long serialVersionUID = -4381322126225374226L;

	public AuditStatus(Integer status, String description){
		super(status, description);
	}
	
	public static AuditStatus AUDITINIT  = new AuditStatus(4, "初始化");
	
    public static AuditStatus AUDITWAIT  = new AuditStatus(0, "审核中");
	
    public static AuditStatus AUDITPASS  = new AuditStatus(2, "审核通过");

    public static AuditStatus AUDITNOPASS = new AuditStatus(1, "审核未通过");

    public static List<AuditStatus> getAllList() {
		return getAll(AuditStatus.class);
	}
    
	public static AuditStatus valueOf(Integer index){
		return valueOf(AuditStatus.class, index);
	}
	
}
