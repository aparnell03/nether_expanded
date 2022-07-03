execute as @e[type=minecraft:piglin] run scoreboard players add @e[type=minecraft:piglin,sort=random,limit=1] mobs 1
execute at @e[type=minecraft:piglin,limit=1,sort=random,scores={mobs=24000..}] run setblock ~ ~ ~ minecraft:barrel{LootTable:"nether:blocks/pigchest"} replace
execute at @e[type=minecraft:piglin,limit=1,sort=random,scores={mobs=24000..}] run scoreboard players set @e[distance=..100,type=minecraft:piglin] mobs 0
effect give @e[type=ghast] slowness 600 3 true

execute as @r in minecraft:the_nether run scoreboard players add @e[type=minecraft:skeleton,sort=random,limit=1,distance=0..] mobs 1
execute as @r in minecraft:the_nether run scoreboard players add @e[type=minecraft:wither_skeleton,sort=random,limit=1,distance=0..] mobs 1
execute as @a if data entity @s {Dimension:"minecraft:the_nether"} run kill @e[type=minecraft:zombie,distance=..1000]
execute at @a run tag @e[type=minecraft:skeleton,distance=..5] add player
kill @e[type=skeleton,scores={mobs=5..},tag=!player]
execute as @e[type=skeleton,scores={mobs=4},tag=!player] at @s run summon minecraft:wither_skeleton ~ ~ ~ {Tags:["bow"]}


item replace entity @e[type=minecraft:wither_skeleton,tag=!bow,scores={mobs=..5}] weapon.mainhand with nether_expanded:blackstone_sword
item replace entity @e[type=minecraft:wither_skeleton,tag=bow,scores={mobs=..5}] weapon.mainhand with minecraft:bow