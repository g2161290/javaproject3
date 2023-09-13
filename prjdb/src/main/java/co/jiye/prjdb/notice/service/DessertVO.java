package co.jiye.prjdb.notice.service;

import lombok.Data;

@Data
public class DessertVO {
	private String dessertCode;
	private String dessertName;
	private String dessertExplain;
	private int dessertPrice;
	private int dessertSale;
	private int dessertGrade;
	private String image;
}
