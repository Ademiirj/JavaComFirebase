package model;

public class EspecieModel {
    public int nivel_protecao;
    private String id;
    public String categoria_ameaca;
    public String especie_simplificado;
    public String bioma;
    public String exclusiva_brasil;
    public String familia;
    public String fauna_ou_flora;
    public String grupo;
    public String nome;
    public String ordenamento_pesqueiro;
    public String plano_conservacao;
    public String areas_protegidas;
    public String principais_ameacas;
    public String sigla_categoria_ameaca;
    public String estados_ocorrencia;

    public String getEstados_ocorrencia() {
        return estados_ocorrencia;
    }

    public void setEstados_ocorrencia(String estados_ocorrencia) {
        this.estados_ocorrencia = estados_ocorrencia;
    }

    public EspecieModel() {
        //Default constructor
    }

    public EspecieModel(String nome, String bioma) {
        this.nome = nome;
        this.bioma = bioma;
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie_simplificado() {
        return especie_simplificado;
    }

    public void setEspecie_simplificado(String especie_simplificado) {
        this.especie_simplificado = especie_simplificado;
    }

    public String getBioma() {
        return bioma;
    }

    public void setBioma(String bioma) {
        this.bioma = bioma;
    }

    public String getExclusiva_brasil() {
        return exclusiva_brasil;
    }

    public void setExclusiva_brasil(String exclusiva_brasil) {
        this.exclusiva_brasil = exclusiva_brasil;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getFauna_ou_flora() {
        return fauna_ou_flora;
    }

    public void setFauna_ou_flora(String fauna_ou_flora) {
        this.fauna_ou_flora = fauna_ou_flora;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public int getNivel_protecao() {
        return nivel_protecao;
    }

    public void setNivel_protecao(int nivel_protecao) {
        this.nivel_protecao = nivel_protecao;
    }

    public String getOrdenamento_pesqueiro() {
        return ordenamento_pesqueiro;
    }

    public void setOrdenamento_pesqueiro(String ordenamento_pesqueiro) {
        this.ordenamento_pesqueiro = ordenamento_pesqueiro;
    }

    public String getPlano_conservacao() {
        return plano_conservacao;
    }

    public void setPlano_conservacao(String plano_conservacao) {
        this.plano_conservacao = plano_conservacao;
    }

    public String getAreas_protegidas() {
        return areas_protegidas;
    }

    public void setAreas_protegidas(String areas_protegidas) {
        this.areas_protegidas = areas_protegidas;
    }

    public String getPrincipais_ameacas() {
        return principais_ameacas;
    }

    public void setPrincipais_ameacas(String principais_ameacas) {
        this.principais_ameacas = principais_ameacas;
    }

    public String getSigla_categoria_ameaca() {
        return sigla_categoria_ameaca;
    }

    public void setSigla_categoria_ameaca(String sigla_categoria_ameaca) {
        this.sigla_categoria_ameaca = sigla_categoria_ameaca;
    }
    

    public String getCategoria_ameaca() {
        return categoria_ameaca;
    }

    public void setCategoria_ameaca(String categoria_ameaca) {
        this.categoria_ameaca = categoria_ameaca;
    }   
}
