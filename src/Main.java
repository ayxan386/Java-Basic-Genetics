public class Main {
    public static Population f = null;
    public static int frames = 0;
    public static boolean flag = false;
    public static void main(String[] args) throws InterruptedException {
        double fps =60;
        f = new Population("Azerbaijan",1500);
        long curr = System.nanoTime();
        long per = (long)((1e+9)/fps);
        //long start = System.nanoTime();
        while(!flag)
        {
            if(curr + per < System.nanoTime())
            {
                curr += per;
                draw();
            }
            //Thread.sleep(100);
           // System.out.println(System.nanoTime() - start);
        }
    }
    public static void draw()
    {
        frames++;
        f.update();
        if(f.showMax() - 1 == 0)flag = true;
        System.out.println("Current frame : " + frames);
        f.newPop();
    }
}