import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;

public class Funcionario extends Pessoa{
    BigDecimal salario;
    String funcao;

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
    public static Funcionario criarFuncionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao){
        Funcionario novoFuncionario = new Funcionario();

        novoFuncionario.setNome(nome);
        novoFuncionario.setDataNascimento(dataNascimento);
        novoFuncionario.setSalario(salario);
        novoFuncionario.setFuncao(funcao);

        return novoFuncionario;
    }

    public static void aumentoSalarialPorPorcentagem(Funcionario funcionario, Double porcentagem){
        BigDecimal novoSalario;
        double porcentaualFormatado = 1 + (porcentagem / 100);
        novoSalario = funcionario.getSalario().multiply(BigDecimal.valueOf(porcentaualFormatado));
        funcionario.setSalario(novoSalario.setScale(2, BigDecimal.ROUND_HALF_EVEN));
    }


}