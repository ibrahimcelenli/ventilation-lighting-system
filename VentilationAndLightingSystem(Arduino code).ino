//pinlerimizi ve kullanacagimiz degiskenleri tanimliyoruz.
int led = 5;
int s1 = 9;
int s2 = 10;
int s3 = 11;
int deger1 = 0;
int deger2= 0;
int deger3= 0;

//serial porttan gelen veriyi char olarak tanimliyoruz.
unsigned char gelen;
 
void setup() {                
  
//pinlerimizin output olarak tanÄ±mlÄ±yoruz.  
pinMode(led, OUTPUT); 
pinMode(s1, OUTPUT);  
pinMode(s2, OUTPUT);  
pinMode(s3, OUTPUT);  
Serial.begin(9600); // 9600 Baud ile haberlesmeye basla
 
}
 
 
void loop()

{

  if(Serial.available()>0){ // Haberlesme kullanilabilir durumda ise
  gelen=Serial.read(); // Java kodundan geleni oku
  Serial.println(gelen);
  
   if(gelen==1) digitalWrite(led, HIGH);  // 1 ise yak
   if(gelen==0) digitalWrite(led, LOW);   // 0 ise sondur
    
   if(gelen==3) {
   
     deger1 = deger1 + 1;
     
        if(deger1%2==1){   // ayni butona tiklayarak islemlerimizi durdurabiliyoruz.
          
          
           digitalWrite(s1, HIGH);// 1 ise yak
      }
       
       else {

     digitalWrite(s1, LOW); 
     
       }
 
 }
 
   if(gelen==4) 
   {
   
     deger2 = deger2 + 1;
     
        if(deger2%2==1){
          
          
           digitalWrite(s2, HIGH);// 1 ise yak
          
          
        }
       
       else {

     digitalWrite(s2, LOW);  // 0 ise sondur
     
       }
   
   }
     if(gelen==5) {
   
   
          deger3 = deger3 + 1;
     
        if(deger3%2==1){
          
          
           digitalWrite(s3, HIGH); // 1 ise yak
          
          
        }
       
       else {

     digitalWrite(s3, LOW);  // 0 ise sondur
     
       }

   
   }

  }  
}
