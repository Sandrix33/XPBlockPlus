����   4 C  XPBlockPlus/Sandrix/Dev/Main  !org/bukkit/plugin/java/JavaPlugin <init> ()V Code
  	   LineNumberTable LocalVariableTable this LXPBlockPlus/Sandrix/Dev/Main; onEnable
    %XPBlockPlus/Sandrix/Dev/Config/Config   CheckConfig
     
loadConfig
    XPBlockPlus/Sandrix/Dev/Join   refreshPlayerCount
    org/bukkit/Bukkit   ! 	getServer ()Lorg/bukkit/Server; # % $ org/bukkit/Server & ' getPluginManager #()Lorg/bukkit/plugin/PluginManager; ) XPBlockPlus/Sandrix/Dev/Event
 ( 	 , . - org/bukkit/plugin/PluginManager / 0 registerEvents 8(Lorg/bukkit/event/Listener;Lorg/bukkit/plugin/Plugin;)V
  	 3 xpp
  5 6 7 
getCommand 6(Ljava/lang/String;)Lorg/bukkit/command/PluginCommand; 9 %XPBlockPlus/Sandrix/Dev/Config/Reload
 8 	
 < > =  org/bukkit/command/PluginCommand ? @ setExecutor '(Lorg/bukkit/command/CommandExecutor;)V 
SourceFile 	Main.java !               /     *� �    
       	                    �     D� � � � � " � (Y� **� + � � " � Y� 1*� + *2� 4� 8Y� :� ;�    
            	    3  C         D      A    B