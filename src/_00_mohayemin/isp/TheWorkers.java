package _00_mohayemin.isp;

interface Worker {
    void work();
}

interface EatingWorker extends Worker {
    void takeLunchBreak();
}

class RegularWorker implements EatingWorker {
    @Override
    public void work() {
        // working
    }

    @Override
    public void takeLunchBreak() {
        // take 30 minutes break and eat in a good meal
    }
}

class Programmer implements EatingWorker {
    @Override
    public void work() {
        // coding
    }

    @Override
    public void takeLunchBreak() {
        // sometimes eat during lunchtime, takes 15 minutes
        // sometimes takes lunch break outside lunch hour
        // sometimes forgets to eat and keeps coding during lunch break
        // sometimes just drink coffee
        // When favorite food is served, eats for an hour!
    }
}

class RobotWorker implements Worker {
    @Override
    public void work() {
        // effeciently work
    }
}

class Manager {
    void manage(Worker worker) {
        worker.work();
    }

    void manageAndFeed(EatingWorker eatingWorker){
        eatingWorker.work();
        eatingWorker.takeLunchBreak();
    }
}