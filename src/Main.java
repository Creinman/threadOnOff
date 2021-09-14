class Main {
    public static void main(String[] args) {
        Toy onoff = new Toy();
        Thread threadUser = new Thread(null, onoff::user, "Юзер");
        Thread threadUser2 = new Thread(null, onoff::user, "Юзер");
        Thread threadToy = new Thread(null, onoff::toy, "Игрушка");
        Thread threadToy2 = new Thread(null, onoff::toy, "Игрушка");
        threadUser.start();
        threadToy.start();
        threadUser2.start();
        threadToy2.start();
        //new User().start();
        //new Toy().start();
    }
}

