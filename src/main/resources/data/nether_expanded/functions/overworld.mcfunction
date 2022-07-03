attribute @e[limit=1,sort=random,type=hoglin] minecraft:generic.follow_range base set 10
attribute @e[limit=1,sort=random,type=zombie] minecraft:generic.movement_speed base set 0.38
data merge entity @e[type=minecraft:zombie,limit=1,sort=random] {IsBaby:0}
attribute @e[limit=1,sort=random,type=husk] minecraft:generic.movement_speed base set 0.4
data merge entity @e[type=minecraft:husk,limit=1,sort=random] {IsBaby:0}
attribute @e[limit=1,sort=random,type=zombie_villager] minecraft:generic.movement_speed base set 0.28
attribute @e[limit=1,sort=random,type=zombie] minecraft:generic.attack_damage base set 10.0
attribute @e[limit=1,sort=random,type=husk] minecraft:generic.attack_damage base set 11.0
attribute @e[limit=1,sort=random,type=zombie_villager] minecraft:generic.attack_damage base set 7.5

execute as @e[type=zombie] at @s run effect give @a[distance=..2] minecraft:nausea 9
execute as @e[type=enderman] at @s run effect give @a[distance=..2] minecraft:blindness 9

effect give @e[type=zombie] resistance 100 3 true
execute in minecraft:overworld as @e[type=skeleton,distance=0..] run effect give @s resistance 100 3 true
execute in minecraft:overworld as @e[type=skeleton,distance=0..] run effect give @s resistance 100 3 true
effect give @e[type=creeper] speed 1 2 true
effect give @e[type=creeper] invisibility 1 2 true
effect give @e[type=spider] speed 100 3 true
effect give @e[type=spider] strength 100 1 true

scoreboard players add @e[type=minecraft:enderman,limit=1,sort=random] mobs 1
scoreboard players add @e[type=minecraft:enderman,limit=1,sort=random] timer 1
execute in minecraft:overworld at @e[type=enderman,scores={mobs=1200..},distance=0..] run execute at @e[type=zombie,sort=random,limit=1] run summon zombie
execute in minecraft:overworld at @e[type=enderman,scores={timer=100..},distance=0..] run spreadplayers ~ ~ 1 10 false @a[distance=5]
execute in minecraft:overworld as @e[type=minecraft:enderman,scores={mobs=1200..},distance=0..] run scoreboard players set @s mobs 0
execute in minecraft:overworld as @e[type=minecraft:enderman,scores={timer=100..},distance=0..] run scoreboard players set @s timer 0


execute in minecraft:overworld at @e[type=lightning_bolt,distance=0..] run summon creeper ~ ~ ~ {Fuse:0}