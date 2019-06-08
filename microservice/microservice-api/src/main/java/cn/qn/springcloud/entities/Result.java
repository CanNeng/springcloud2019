package cn.qn.springcloud.entities;

import lombok.Data;

@Data
public class Result {
    private int code;
    private int subCode;
    private String msg;
    private Object data;

    public Result() {
    }

    public Result(int code) {
        this.code = code;
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(int code, int subCode, String msg) {
        this.code = code;
        this.subCode = subCode;
        this.msg = msg;
    }

    public Result(int code, int subCode, String msg, Object data) {
        this.code = code;
        this.subCode = subCode;
        this.msg = msg;
        this.data = data;
    }

    public static Result success(String msg) {
        return new Result(1, msg);
    }

    public static Result success(Object data) {
        return new Result(1, "ok", data);
    }

    public static Result success(String msg, Object data) {
        return new Result(1, msg, data);
    }

    public static Result error(int subCode, String msg) {
        return new Result(0, subCode, msg);
    }

    public static Result error(String msg) {
        return new Result(0, 0, msg);
    }

    public static Result error(int subCode, String msg, Object data) {
        return new Result(0, subCode, msg, data);
    }


}
