class Main {
    public static void main(String[] args) {
        final Switch switchon = new Switch();
        Thread threadUser = new Thread(null, switchon::user, "Юзер");
        Thread threadToy = new Thread(null, switchon::toy, "производитель");
        threadUser.start();

        try {
            threadUser.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadToy.start();
        threadUser.interrupt();
        threadToy.interrupt();
    }
}

