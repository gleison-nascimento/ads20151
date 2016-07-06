package br.edu.ifrs.modelo.bean;

public class Solicitacoes {
    private String solicitante;
    private String entidade;
    private String email;
    private String tel;
    private String objetivo;
    private String data;
    private String dataInicio;
    private String horaInicio;
    private String dataTermino;
    private String horaTermino;
    private int id;
    private String situacao;
    private String dataReserva;
    private String obs;
    private String espacoReservado;

    public Solicitacoes() {
        this.solicitante = "";
        this.entidade = "";
        this.email = "";
        this.tel = "";
        this.objetivo = "";
        this.data = "";
        this.dataInicio = "";
        this.horaInicio = "";
        this.dataTermino = "";
        this.horaTermino = "";
        this.situacao = "pendente";
    }

    public String getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(String dataReserva) {
        this.dataReserva = dataReserva;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getEspacoReservado() {
        return espacoReservado;
    }

    public void setEspacoReservado(String espacoReservado) {
        this.espacoReservado = espacoReservado;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) throws Exception {
        if(solicitante == null || solicitante.equals("")) {
            throw new Exception("O campo `Solicitante´ é de preenchimento obrigatório.");
        }
        this.solicitante = solicitante;
    }

    public String getEntidade() {
        return entidade;
    }

    public void setEntidade(String entidade) {
        this.entidade = entidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        if(email == null || email.equals("")) {
            throw new Exception("O campo `Email de contato´ é de preenchimento obrigatório.");
        }
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) throws Exception {
        if(tel == null || tel.equals("")) {
            throw new Exception("O campo `Telefone de contato´ é de preenchimento obrigatório.");
        }
        this.tel = tel;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) throws Exception {
        if(objetivo == null || objetivo.equals("")) {
            throw new Exception("O campo `Objetivo da reserva do espaço´ é de preenchimento obrigatório.");
        }
        this.objetivo = objetivo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) throws Exception {
        if(dataInicio == null || dataInicio.equals("")) {
            throw new Exception("O campo `Data de início da reserva´ é de preenchimento obrigatório.");
        }
        this.dataInicio = dataInicio;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) throws Exception {
        if(horaInicio == null || horaInicio.equals("")) {
            throw new Exception("O campo `Hora de início da reserva´ é de preenchimento obrigatório.");
        }
        this.horaInicio = horaInicio;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(String dataTermino) throws Exception {
        if(dataTermino == null || dataTermino.equals("")) {
            throw new Exception("O campo `Data de término da reserva´ é de preenchimento obrigatório.");
        }
        this.dataTermino = dataTermino;
    }

    public String getHoraTermino() {
        return horaTermino;
    }

    public void setHoraTermino(String horaTermino) throws Exception {
        if(horaTermino == null || horaTermino.equals("")) {
            throw new Exception("O campo `Hora de término da reserva´ é de preenchimento obrigatório.");
        }
        this.horaTermino = horaTermino;
    }
}