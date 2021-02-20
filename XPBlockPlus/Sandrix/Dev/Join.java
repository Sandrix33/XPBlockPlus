����   4 �  XPBlockPlus/Sandrix/Dev/Join  java/lang/Object  org/bukkit/event/Listener l Ljava/util/ArrayList; 	Signature BLjava/util/ArrayList<LXPBlockPlus/Sandrix/Dev/Config/PlayerList;>; trov Z <clinit> ()V Code  java/util/ArrayList
     <init>	     LineNumberTable LocalVariableTable
   this LXPBlockPlus/Sandrix/Dev/Join; onJoin ,(Lorg/bukkit/event/player/PlayerJoinEvent;)V RuntimeVisibleAnnotations Lorg/bukkit/event/EventHandler;	  !  
  # $ % 	getPlayer (I)Ljava/lang/String;
 ' ) ( 'org/bukkit/event/player/PlayerJoinEvent $ * ()Lorg/bukkit/entity/Player; , . - org/bukkit/entity/Player / 0 getName ()Ljava/lang/String;
 2 4 3 java/lang/String 5 6 equals (Ljava/lang/Object;)Z
  8 9 : getCSizeList ()I < )XPBlockPlus/Sandrix/Dev/Config/PlayerList
 > @ ? %XPBlockPlus/Sandrix/Dev/Config/Config A B getCountList ()Ljava/util/ArrayList;
 ; D  E *(Ljava/lang/String;Ljava/util/ArrayList;)V
  G H 6 add e )Lorg/bukkit/event/player/PlayerJoinEvent; k I name Ljava/lang/String; pl +LXPBlockPlus/Sandrix/Dev/Config/PlayerList; StackMapTable refreshPlayerCount
  T U  clear
 W Y X org/bukkit/Bukkit Z [ getOnlinePlayers ()Ljava/util/Collection; ] _ ^ java/util/Collection ` a iterator ()Ljava/util/Iterator; c e d java/util/Iterator f g next ()Ljava/lang/Object; , ) c j k l hasNext ()Z player Lorg/bukkit/entity/Player;
  p q : size
  s t u get (I)Ljava/lang/Object;
 ; . i getMatCount (Ljava/lang/String;II)I
 ; { | B getList ~ java/lang/Integer
 } � � : intValue j 
resetCount (Ljava/lang/String;II)V
  � � � addAll (Ljava/util/Collection;)Z
 } � � � valueOf (I)Ljava/lang/Integer;
  � � � set '(ILjava/lang/Object;)Ljava/lang/Object;
 ; � � � setList (Ljava/util/ArrayList;)V c LocalVariableTypeTable *Ljava/util/ArrayList<Ljava/lang/Integer;>; IncrementCount 
SourceFile 	Join.java !          	    
       	        +      � Y� � �                         /     *� �                                       �     V*�  =� � "+� &� + � 1� *�  �� 7���*�  � $+� &� + M� ;Y,� =� CN� -� FW� ��       2       
    "  ,  3   = " I # Q % T ' U )    4    V       V I J   % K L  =  M N  I  O P  Q    � 
� .  	 R      �     F� � S� V� \ L� -+� b � ,K*� h � + M� ;Y,� =� CN� -� FW+� i ��б           -  /  0 ( 2 4 3 < / E 7          m n   (  M N  4  O P  Q    �    c  ) 	 9 :     '      � � o�           :       	 $ %     8     � � r� ;� v�           >         w L   	 x y     V     � � r� ;� z� r� }� �           D          M N      w L     � L  	 � �     �     )� Y� N-� =� �W-� �� �W� � r� ;-� ��           J  K  M  O ( Q    *    ) M N     ) w L    ) � L   ! �   �      ! � �  	 � �     �     5� Y� N-� =� �W--� r� }� `� �� �W� � r� ;-� ��           U  V  X & Z 4 \    *    5 M N     5 w L    5 � L   - �   �      - � �   �    �