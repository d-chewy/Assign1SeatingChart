import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The DarrenChui class represents me and my seating location in AP CSA
 * 
 * @author Mr. Kaehms
 * @version 2.0 Aug 13, 2019
 */
public class DarrenChui extends Student implements SpecialInterestOrHobby
{

    /**
     * Constructor for the DarrenChui class.
     * Constructors are special methods with the same exact name as the class name.  
     * Constructors to not have return types.
     * Constructors can be overloaded. This means we can call a constructor with different sets of parameter
     *  lists to initalize for different conditions (depending on what constructors have been written.
     * @param String f (firstname)
     * @param String l (lastname)
     * @param int r (row of seating arrangement)
     * @param int s (seat number within row seating arrangement)
     * 
     */
    public DarrenChui(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        myRow=r;
        mySeat=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.png";
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        setImage(portraitFile);
        sitting=true;
    }
    
    /**
     * Default constructor, passed in name and seating location
     */
    public DarrenChui() {
        firstName="Darren";
        lastName="Chui";
        myRow=1;
        mySeat=4;
        // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.png";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
    }
    
     /**
     * Act - do whatever the DarrenChui actor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */   
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            if (sitting){
                sitting=false;
                setImage(standingFile);
                getImage().mirrorHorizontally();
                System.out.println(""); // Print a blank line to create space between any student output.
                getName();
                sayName(soundFile);
                myHobby("I like to play competitive shooter or survival sandbox video games.");
                
                circleClass();  // Darren Chui's special method
            }
            else {
                answerQuestion();
                sitDown();
            }   
        }
    } 
    
    /**
     * Prints the first and last name to the console
     */
    public void getName(){
        System.out.println("My name is " + firstName + " " + lastName + ".");
    }
    
    /**
     * Method asks user if the actor can sit back down until granted privilege.
     */
    
    public void askSitDown(String q) {
        sitDownLoop:
        while (q != "yes") {
            q=Greenfoot.ask("May I sit down?");
            if (q.equals("yes")) {
                Greenfoot.delay(10);
                sitDown();
                break sitDownLoop;
            }
        }
    }
    
    /**
     * This method allows the user to interact with the student through a question and answer interface, and provides
     * a mechanism that allows the student to sit down once the Q&A session ends.
     */
    
    public void answerQuestion(){
        int numQuestions = 7;
        
        // 2D array for storing questions and answers
        String questionsArray [][] = new String [2] [numQuestions];
        
        // adds questions and answers to the array
        questionsArray[0][0] = "hard";
        questionsArray[1][0] = "2D arrays, recursion, and merge sort...";
        
        questionsArray[0][1] = "video game";
        questionsArray[1][1] = "My favorite video games right now are Apex Legends and Minecraft...";
        
        questionsArray[0][2] = "old";
        questionsArray[1][2] = "I am 16 years old right now...";
        
        questionsArray[0][3] = "food";
        questionsArray[1][3] = "My favorite food is Dried Scallop and Egg White Fried Rice...";
        
        questionsArray[0][4] = "cartoon";
        questionsArray[1][4] = "My favorite cartoon is Avatar: The Last Airbender...";
        
        questionsArray[0][5] = "minecraft";
        questionsArray[1][5] = "I play Minecraft on the hypixel.net server and the official Dublin High School server owned by Jacob Sommer...";
        
        questionsArray[0][6] = "classes";
        questionsArray[1][6] = "I am taking Trig Precalc, AP Chem, AP Lang, APCSA, AP Mandarin, and APUSH as of Junior year 2019-2020...";
        
        // asks user what question they have and returns an answer
        String q = Greenfoot.ask("Whew, I somehow made my way out of that isekai... More importantly, what would you like to know?");
        
        // flags whether or not question is in 2d array
        boolean understand = false; 
        
        // flags question row/column
        int qr = 0;
        int qc = 0;
        
        // checks for keywords in questions and flags
        keyWordSearch:
        for (int r = 0; r < questionsArray.length; r++){
            for (int c = 0; c < questionsArray[r].length; c++) {
                if (q.contains(questionsArray[r][c])) {
                    understand = true;
                    qr = r+1;
                    qc = c;
                    break keyWordSearch;
                }
            }
        }
        
        // answers question if possible and asks if actor can sit down
        if (understand == true) {
            q = Greenfoot.ask(questionsArray[qr][qc] + " Press enter to continue.");
            askSitDown(q);
        }
        else {
            q = Greenfoot.ask("I don't understand the question... Press enter to continue.");
            askSitDown(q);
        }
    }
    
    /**
     * This is a local method specific to the DarrenChui class used to animate the character once the image is clicked on.
     */
    public void circleClass(){
        int [][] rdmTrans = new int [4][4];
        for (int r = 0; r < rdmTrans.length; r++) {
            for (int c = 0; c < rdmTrans[r].length; c++) {
                rdmTrans[r][c] = Greenfoot.getRandomNumber(255);
            }
        }
        
        setLocation(0,1);
        Greenfoot.delay(10);
        // move right
        for (int i=1;i<=10;i++){
            setLocation(i,1);
            Greenfoot.delay(2);
        }
        // move down
        for (int i=1;i<=6;i++){
            setLocation(10,i);
            Greenfoot.delay(2);
        }      
         // move left
        this.getImage().mirrorHorizontally();
        for (int i=10;i>=0;i--){
            setLocation(i,6);
            Greenfoot.delay(2);
        }      
        // move up
        for (int i=6;i>=0;i--){
            setLocation(0,i);
            Greenfoot.delay(2);
        } 
        // move diagonally and rotate
        for (int i=1;i<=6;i++) {
            setLocation(i,i);
            getImage().rotate(360/6);
            Greenfoot.delay(2);
        }
        // randomly telport in and out of existence
        for (int i=0;i<32;i++) {
            setLocation(Greenfoot.getRandomNumber(10), Greenfoot.getRandomNumber(5));
            getImage().rotate(360/32);
            getImage().setTransparency(rdmTrans[Greenfoot.getRandomNumber(3)][Greenfoot.getRandomNumber(3)]);
            Greenfoot.delay(4);
        }
        returnToSeat();
        Greenfoot.delay(200);
        
        truck truck = new truck();
        getWorld().addObject(truck, 10, 1);
    }
    
    // prints hobbies in terminal window
    public void myHobby(String s) {
             System.out.println(s);
    }
}
