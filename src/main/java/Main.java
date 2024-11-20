import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String carName;
        int carSpeed;
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();

        for(int i = 0; i < 3; i++){
            System.out.printf("Введите название машины №%d:\n", i + 1);
            carName = scanner.next();
            while (true) {
                System.out.printf("Введите скорость машины №%d:\n", i + 1);
                carSpeed = scanner.nextInt();
                if (carSpeed < 0 || carSpeed > 250){
                    System.out.println("Неправильная скорость");
                } else {
                    break;
                }
            }
            Car curCar = new Car(carName, carSpeed);
            race.updateLeader(curCar);
        }
        race.printLeader();
    }
}

class Car {
    // Я понимаю, что можно вместо private оставить public и использовать, как атрибут класса.
    // Но это лишний раз запретит в будущем создать автомобиль с запрещенными параметрами внутри этого файла
    private String name;
    private int speed;

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return this.name;
    }

    public int getSpeed() {
        return this.speed;
    }
}

class Race {
    private String leader;
    private int leaderDist;

    public Race() {
        this.leader = "";
        this.leaderDist = 0;
    }

    public void updateLeader(Car curCar) {
        int curCarDist = curCar.getSpeed() * 24;
        if (curCarDist > this.leaderDist) {
            this.leader = curCar.getName();
            this.leaderDist = curCarDist;
        }
    }

    public void printLeader() {
        System.out.println("Самая быстрая машина: " + this.leader);
    }

}