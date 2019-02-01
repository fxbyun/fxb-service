package domain.entity;



import domain.util.MD5;

import java.io.Serializable;


public abstract class BaseEntity implements Serializable {
    private static final long serialVersionUID = 6591689521930282427L;
    /**主键*/
    public Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** 为继承它的实体提供统一的编码字段的方法 */
    public String encodeFiled() {
        StringBuilder origendFiled = getOrigendFiled();
        if (origendFiled != null)
            return MD5.encode(origendFiled.toString());
        return null;
    }

    /** 由需要的编码字段的实体去覆盖 */
    protected StringBuilder getOrigendFiled() {
        return null;
    }

}
