package weaver.interfaces.gx.jyl.gfgs.cxdgyfk;

import weaver.conn.RecordSet;
import weaver.general.BaseBean;
import weaver.general.Util;
import weaver.interfaces.workflow.action.Action;
import weaver.soa.workflow.request.Cell;
import weaver.soa.workflow.request.DetailTable;
import weaver.soa.workflow.request.RequestInfo;
import weaver.soa.workflow.request.Row;

/**
 * 股份公司-股份公司冲销对公预付款冻结
 */
public class CXDGYFKDJAction extends BaseBean implements Action {

	public String execute(RequestInfo request) {
		// 冲销金额-值
		String cxje_value = "";
		// 冲销金额-字段
		String cxje_column = "cxyfkje";
		// 借款单号-值
		String jkdh_value = "";
		// 借款单号-字段
		String jkdh_column = "yfkdh";

		RecordSet rs = new RecordSet();

		String src = request.getRequestManager().getSrc();
		if (!"submit".equals(src)) {
			return SUCCESS;
		}

		DetailTable[] detailtable = request.getDetailTableInfo().getDetailTable();// 获取所有明细表
		DetailTable dt = detailtable[1];// 指定明细表 0表示明细表1
		Row[] s1 = dt.getRow();// 当前明细表的所有数据,按行存储
		for (int j = 0; j < s1.length; j++) {
			Row r = s1[j];// 指定行
			Cell c[] = r.getCell();// 每行数据再按列存储
			for (int k = 0; k < c.length; k++) {
				Cell c1 = c[k];// 指定列
				String name = c1.getName();// 明细字段名称（对应明细表表单字段名称，如：mx_name）
				String value = c1.getValue();// 明细字段的值（对应明细表表单中的mx_name的值）
				if (cxje_column.equals(name)) {
					cxje_value = value;
				}
				if (jkdh_column.equals(name)) {
					jkdh_value = value;
				}
			}
		}

		writeLog("冲销金额：" + cxje_value);
		writeLog("预付款单号：" + jkdh_value);

		double dou = Util.getDoubleValue(cxje_value, 0);
		String sql = "update formtable_main_1105 set hkztje=nvl(hkztje,0)+'" + dou + "' where id='" + jkdh_value
				+ "'  ";
		writeLog("提交将冲借款金额变为在途 : " + sql);
			rs.execute(sql);
		return SUCCESS;
	}

}
