class Main {
    public static void main(String[] args) {
        Toy onoff = new Toy();
        Thread threadUser = new Thread(null, onoff::user, "Юзер");
        Thread threadToy = new Thread(null, onoff::toy, "Игрушка");
        threadUser.start();
        threadToy.start();
    }
}

