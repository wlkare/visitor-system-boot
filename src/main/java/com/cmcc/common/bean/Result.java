package com.cmcc.common.bean;

public class  Result {
	
	private Integer code;

    private String msg;

    private Object data;

    public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	private void setResultCode(ResultCode code) {
        this.code = code.code();
        this.msg = code.message();
    }
	
	public static Result success() {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    public static Result error() {
        Result result = new Result();
        result.setResultCode(ResultCode.ERROR);
        return result;
    }

    public static Result error(Object data) {
        Result result = new Result();
        result.setResultCode(ResultCode.ERROR);
        result.setData(data);
        return result;
    }
    
    public static Result failure(ResultCode resultCode) {
        Result result = new Result();
        result.setResultCode(resultCode);
        return result;
    }

    public static Result failure(ResultCode resultCode, Object data) {
        Result result = new Result();
        result.setResultCode(resultCode);
        result.setData(data);
        return result;
    }

}
