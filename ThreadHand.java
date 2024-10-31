import java.util.Random;

class ThreadHand extends Thread {
    tradetime timecount;
    int handX, handY = 710;
    boolean ishand = false;
    Random random = new Random();

    ThreadHand(tradetime timecount) {
        this.timecount = timecount;
    }

    @Override
    public void run() {
        while (timecount.isend) {
            // แสดงมือพร้อมสุ่มตำแหน่งใหม่
            ishand = true;
            handX = random.nextInt(700) + 3;

            try {
                Thread.sleep(2000); // วาดมืออยู่ 2 วินาที
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // ซ่อนมือแล้วรอ 10 วินาทีก่อนสุ่มแสดงใหม่
            ishand = false;
            try {
                Thread.sleep(10000); // หายไป 10 วินาที
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
