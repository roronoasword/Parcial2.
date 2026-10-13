public class Profesor extends Persona {
    private static final double VALOR_HORA = 50000; // valor supuesto

    private String area;
    private double salarioBase;
    private int horasCatedra;

    public Profesor(String nombre, int edad, String documento,
                    String area, double salarioBase, int horasCatedra) {
        super(nombre, edad, documento);
        this.area = area;
        this.salarioBase = salarioBase;
        this.horasCatedra = horasCatedra;
    }

    public String getArea() { return area; }
    public double getSalarioBase() { return salarioBase; }
    public int getHorasCatedra() { return horasCatedra; }

    // Salario total = salario base + (horas cátedra * valor por hora)
    public double calcularSalario() {
        return salarioBase + (horasCatedra * VALOR_HORA);
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Área:      " + area);
        System.out.println("Sal. base: $" + salarioBase);
        System.out.println("Horas:     " + horasCatedra);
        System.out.println("Sal. total: $" + calcularSalario());
    }

    @Override
    public String getRol() {
        return "Profesor";
    }
}