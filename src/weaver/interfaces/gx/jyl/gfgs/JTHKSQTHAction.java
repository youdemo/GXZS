package weaver.interfaces.gx.jyl.gfgs;

import weaver.conn.RecordSet;
import weaver.general.BaseBean;
import weaver.general.Util;
import weaver.interfaces.workflow.action.Action;
import weaver.soa.workflow.request.Property;
import weaver.soa.workflow.request.RequestInfo;

/**
 * 集团-差旅费报销提交冻结
 */
public class JTHKSQTHAction extends BaseBean implements Action {

	public String execute(RequestInfo request) {

		// 还款金额-值
		String hkje_value = "";
		// 还款金额-字段
		String hkje_column = "hkje";
		// 借款单号-值
		String hxjkdh_value = "";
		// 借款单号-字段
		String hxjkdh_column = "hxjkdh";

		RecordSet rs = new RecordSet();

		/*
		 * String src = request.getRequestManager().getSrc(); if(!"submit".equals(src))
		 * { return SUCCESS; }
		 */

		Property[] properties = request.getMainTableInfo().getProperty();// 获取表单主字段信息
		for (int i = 0; i < properties.length; i++) {
			String name = properties[i].getName();// 主字段名称
			String value = Util.null2String(properties[i].getValue());// 主字段对应的值

			if (name.equals(hkje_column)) {
				hkje_value = value;
			}
			if (name.equals(hxjkdh_column)) {
				hxjkdh_value = value;
			}

		}

		writeLog("退回还款金额：" + hkje_value);
		writeLog("退回冲销借款单号：" + hxjkdh_value);

		double dou = Util.getDoubleValue(hkje_value, 0);
		writeLog("退回提交将还款金额变为在途累计金额：" + dou);

		String tablename = getPropValue("GXBX", "GFGS_FYJK");
		String sql = "update " + tablename + " set hkztje=nvl(hkztje,0)-'" + dou + "' where id='" + hxjkdh_value + "' ";
		writeLog("退回提交将冲借款金额变为在途 : " + sql);
		rs.execute(sql);

		return SUCCESS;
	}
}
