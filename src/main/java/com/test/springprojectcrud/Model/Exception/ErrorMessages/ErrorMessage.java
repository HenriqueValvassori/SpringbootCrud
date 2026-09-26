package com.test.springprojectcrud.Model.Exception.ErrorMessages;

public class ErrorMessage {

    private String Title;

    private Integer Status;

    private String mensagem;

    public ErrorMessage(String title, Integer status, String mensagem) {
        Title = title;
        Status = status;
        this.mensagem = mensagem;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
