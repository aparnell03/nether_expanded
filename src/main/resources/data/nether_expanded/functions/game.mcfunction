execute as @a if data entity @s {cardinal_components:{"apoli:powers":{Powers: [{Type: "nether_expanded:zombie"}]}}} run tag @s[tag=!done] add zombified_piglin
execute as @a if data entity @s {Dimension:"minecraft:the_nether"} at @a[tag=zombified_piglin] run summon summon zombified_piglin ~ ~ ~ {PersistenceRequired:1,CanPickUpLoot:1b,HandItems:[{Count:1,id:golden_sword},{Count:1,id:golden_pickaxe}],HandDropChances:[1.0f,1.0f],ActiveEffects:[{Id:11,Amplifier:0,Duration:30}]}

execute as @a if data entity @s {cardinal_components:{"apoli:powers":{Powers: [{Type: "nether_expanded:skeleton"}]}}} run tag @s[tag=!done] add wither_skeleton
execute as @a if data entity @s {Dimension:"minecraft:the_nether"} at @a[tag=wither_skeleton] run summon summon wither_skeleton ~ ~ ~ {PersistenceRequired:1,CanPickUpLoot:1b,HandItems:[{Count:1,id:"nether_expanded:blackstone_sword"},{Count:1,id:"nether_expanded:blackstone_pickaxe"}],HandDropChances:[1.0f,1.0f],ActiveEffects:[{Id:11,Amplifier:0,Duration:30}]}

execute as @a if data entity @s {Dimension:"minecraft:the_nether"} run requiem vagrant set true @a[tag=zombified_piglin]
execute as @a if data entity @s {Dimension:"minecraft:the_nether"} run requiem vagrant set true @a[tag=wither_skeleton]
execute as @a if data entity @s {Dimension:"minecraft:the_nether"} run tag @a[tag=!done] add done

tag @a remove zombified_piglin
tag @a remove wither_skeleton