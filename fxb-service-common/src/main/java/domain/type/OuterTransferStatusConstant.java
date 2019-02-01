package domain.type;
/**
 * 外部划转状态
 * 0：刚创建/未进行
 * 1：进行中
 * 2：完成
 * 3：未明故障需人员介入
 * */
public class OuterTransferStatusConstant {
	public static int notDo = 0;
	public static int doing =1;
	public static int done =2;
	public static int unknownFault =3;
}
