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
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=f.toLowerCase()+l.toLowerCase()+".mp3";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
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
       standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
       soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".mp3";
       setImage(portraitFile);
       sitting=true;
    }
    
     /**
     * Act - do whatever the DarrenChui actor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */   
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
            if (sitting){
                sitting=false;
                setImage(standingFile);
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
     * This method allows the user to interact with the student through a question and answer interface, and provides
     * a mechanism that allows the student to sit down once the Q&A session ends.
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
    
    public void answerQuestion(){
        // 2D array for storing questions and answers
        String questionsArray [][] = new String [2] [5];
        
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
        
        // asks user what question they have and returns an answer
        String q = Greenfoot.ask("What would you like to know?");
        
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
        setLocation(0,0);
         Greenfoot.delay(10);
        // move right
        for (int i=1;i<=9;i++){
            setLocation(i,0);
            Greenfoot.delay(4);
        }
        // move back
        for (int i=1;i<=5;i++){
            setLocation(9,i);
            Greenfoot.delay(4);
        }      
         // move left
        for (int i=9;i>=0;i--){
            setLocation(i,5);
            Greenfoot.delay(4);
        }      
              // move Forward
        for (int i=5;i>=0;i--){
            setLocation(0,i);
            Greenfoot.delay(4);
        } 
              // move diagonally and rotate
        for (int i=0;i<=6;i++) {
            setLocation(i,i);
            getImage().rotate(360/7);
            Greenfoot.delay(4);
        }
        for (int i=0;i<32;i++) {
            setLocation(Greenfoot.getRandomNumber(10), Greenfoot.getRandomNumber(5));
            getImage().rotate(360/32);
            Greenfoot.delay(2);
        }
        Greenfoot.delay(20);
        returnToSeat();
    }
    
    public void myHobby(String s) {
             System.out.println(s);
    }
}
