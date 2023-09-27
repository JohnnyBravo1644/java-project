import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public void main(String[] args) {

        DecimalFormat formatacaoDinheiro = new DecimalFormat("###,###,##0.00");

        List<Funcionario> listaFuncionarios = this.criarListaFuncionarios();

        listaFuncionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));

        this.imprimiFuncionariosList(listaFuncionarios);

        for (Funcionario funcionario : listaFuncionarios){
            Funcionario.aumentoSalarialPorPorcentagem(funcionario, 10.0);
        }

        Map<String, List<Funcionario>> funcionariosPorFuncao = listaFuncionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));

        for (Map.Entry<String, List<Funcionario>> entry : funcionariosPorFuncao.entrySet()) {
            System.out.println("Function: " + entry.getKey());
            for (Funcionario funcionario : entry.getValue()) {
                System.out.println(funcionario.getNome()+ " " + funcionario.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                        + " " + formatacaoDinheiro.format(funcionario.getSalario())+ " " + funcionario.getFuncao());
            }
        }

        for (Funcionario funcionario : listaFuncionarios) {
            LocalDate dataNascimento = funcionario.getDataNascimento();
            if (dataNascimento.getMonthValue() == 9 || dataNascimento.getMonthValue() == 11) {
                System.out.println(funcionario.getNome());
            }
        }

        //3.9 terminar

        List<Funcionario> listaFuncionariosOrdenadaPeloNome = listaFuncionarios.stream().sorted(Comparator.comparing(Funcionario::getNome)).collect(Collectors.toList());
        this.imprimiFuncionariosList(listaFuncionariosOrdenadaPeloNome);

        BigDecimal salarioTotalFuncionario = BigDecimal.valueOf(0.0);
        for (Funcionario funcionario : listaFuncionarios) {
            salarioTotalFuncionario = (salarioTotalFuncionario).add(funcionario.getSalario());
        }
        System.out.println(salarioTotalFuncionario);

        for (Funcionario funcionario : listaFuncionarios) {
            BigDecimal salarioFuncionario = funcionario.getSalario();
            BigDecimal salariominimo = BigDecimal.valueOf(1212.00);
            BigDecimal salarioEmSalariosMinimos = salarioFuncionario.divide(salariominimo, 2, RoundingMode.HALF_UP);
            System.out.println(funcionario.getNome() + " recebe " + salarioEmSalariosMinimos + " salarios minimos");
        }

    }

    public void imprimiFuncionariosList(List<Funcionario> listaFuncionarios){
        DecimalFormat formatacaoDinheiro = new DecimalFormat("###,###,##0.00");
        for (Funcionario funcionario : listaFuncionarios){
            System.out.println(funcionario.getNome()+ " " + funcionario.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                    + " " + formatacaoDinheiro.format(funcionario.getSalario())+ " " + funcionario.getFuncao());
        }
    }

    public List<Funcionario> criarListaFuncionarios(){
        List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();

        Funcionario funcionario1 = Funcionario.criarFuncionario("Maria", LocalDate.parse("2000-10-18"),
                new BigDecimal("20009.44"), Funcao.OPERADOR.getNomeFuncao());
        Funcionario funcionario2 = Funcionario.criarFuncionario("João", LocalDate.parse("1990-05-12"),
                new BigDecimal("2284.38"), Funcao.OPERADOR.getNomeFuncao());
        Funcionario funcionario3 = Funcionario.criarFuncionario("Caio", LocalDate.parse("1961-05-02"),
                new BigDecimal("9836.14"), Funcao.COORDENADOR.getNomeFuncao());
        Funcionario funcionario4 = Funcionario.criarFuncionario("Miguel", LocalDate.parse("1988-10-14"),
                new BigDecimal("19119.88"), Funcao.DIRETOR.getNomeFuncao());
        Funcionario funcionario5 = Funcionario.criarFuncionario("Alice", LocalDate.parse("1995-01-05"),
                new BigDecimal("2234.68"), Funcao.RECEPCIONISTA.getNomeFuncao());
        Funcionario funcionario6 = Funcionario.criarFuncionario("Heitor", LocalDate.parse("1999-11-19"),
                new BigDecimal("1582.72"), Funcao.OPERADOR.getNomeFuncao());
        Funcionario funcionario7 =  Funcionario.criarFuncionario("Arthur", LocalDate.parse("1993-03-31"),
                new BigDecimal("4071.84"), Funcao.CONTADOR.getNomeFuncao());
        Funcionario funcionario8 = Funcionario.criarFuncionario("Laura", LocalDate.parse("1994-07-08"),
                new BigDecimal("3017.45"), Funcao.GERENTE.getNomeFuncao());
        Funcionario funcionario9 = Funcionario.criarFuncionario("Heloísa", LocalDate.parse("2003-05-24"),
                new BigDecimal("1606.85"), Funcao.ELETRICISTA.getNomeFuncao());
        Funcionario funcionario10 = Funcionario.criarFuncionario("Helena", LocalDate.parse("1996-09-02"),
                new BigDecimal("2799.93"), Funcao.GERENTE.getNomeFuncao());

        listaFuncionarios.add(funcionario1);
        listaFuncionarios.add(funcionario2);
        listaFuncionarios.add(funcionario3);
        listaFuncionarios.add(funcionario4);
        listaFuncionarios.add(funcionario5);
        listaFuncionarios.add(funcionario6);
        listaFuncionarios.add(funcionario7);
        listaFuncionarios.add(funcionario8);
        listaFuncionarios.add(funcionario9);
        listaFuncionarios.add(funcionario10);

        return listaFuncionarios;
    }
}