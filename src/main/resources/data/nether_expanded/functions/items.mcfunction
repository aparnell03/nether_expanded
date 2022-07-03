execute as @e[type=item,nbt={Item:{id:"minecraft:book",Count:1b,tag:{display:{Name:"{\"text\":\"wood\"}"}}}}] run clear @p[tag=!selected]
execute as @e[type=item,nbt={Item:{id:"minecraft:book",Count:1b,tag:{display:{Name:"{\"text\":\"stone\"}"}}}}] run clear @p[tag=!selected]
execute as @e[type=item,nbt={Item:{id:"minecraft:book",Count:1b,tag:{display:{Name:"{\"text\":\"food\"}"}}}}] run clear @p[tag=!selected]
execute as @e[type=item,nbt={Item:{id:"minecraft:book",Count:1b,tag:{display:{Name:"{\"text\":\"heal\"}"}}}}] run clear @p[tag=!selected]
execute as @e[type=item,nbt={Item:{id:"minecraft:book",Count:1b,tag:{display:{Name:"{\"text\":\"wood\"}"}}}}] run give @p[tag=!selected] wooden_pickaxe
execute as @e[type=item,nbt={Item:{id:"minecraft:book",Count:1b,tag:{display:{Name:"{\"text\":\"wood\"}"}}}}] run give @p[tag=!selected] wooden_axe
execute as @e[type=item,nbt={Item:{id:"minecraft:book",Count:1b,tag:{display:{Name:"{\"text\":\"wood\"}"}}}}] run give @p[tag=!selected] crafting_table
execute as @e[type=item,nbt={Item:{id:"minecraft:book",Count:1b,tag:{display:{Name:"{\"text\":\"wood\"}"}}}}] run give @p[tag=!selected] stick 2

execute as @e[type=item,nbt={Item:{id:"minecraft:book",Count:1b,tag:{display:{Name:"{\"text\":\"stone\"}"}}}}] run give @p[tag=!selected] blackstone 14 
execute as @e[type=item,nbt={Item:{id:"minecraft:book",Count:1b,tag:{display:{Name:"{\"text\":\"stone\"}"}}}}] run give @p[tag=!selected] furnace

execute as @e[type=item,nbt={Item:{id:"minecraft:book",Count:1b,tag:{display:{Name:"{\"text\":\"food\"}"}}}}] run give @p[tag=!selected] cooked_porkchop 8 

execute as @e[type=item,nbt={Item:{id:"minecraft:book",Count:1b,tag:{display:{Name:"{\"text\":\"heal\"}"}}}}] run give @p[tag=!selected] golden_apple 4 

execute as @e[type=item,nbt={Item:{id:"minecraft:book",Count:1b,tag:{display:{Name:"{\"text\":\"wood\"}"}}}}] run tag @p add selected
execute as @e[type=item,nbt={Item:{id:"minecraft:book",Count:1b,tag:{display:{Name:"{\"text\":\"stone\"}"}}}}] run tag @p add selected
execute as @e[type=item,nbt={Item:{id:"minecraft:book",Count:1b,tag:{display:{Name:"{\"text\":\"food\"}"}}}}] run tag @p add selected
execute as @e[type=item,nbt={Item:{id:"minecraft:book",Count:1b,tag:{display:{Name:"{\"text\":\"heal\"}"}}}}] run tag @p add selected
execute as @e[type=item,nbt={Item:{id:"minecraft:book",Count:1b,tag:{display:{Name:"{\"text\":\"wood\"}"}}}}] run kill @s
execute as @e[type=item,nbt={Item:{id:"minecraft:book",Count:1b,tag:{display:{Name:"{\"text\":\"stone\"}"}}}}] run kill @s
execute as @e[type=item,nbt={Item:{id:"minecraft:book",Count:1b,tag:{display:{Name:"{\"text\":\"food\"}"}}}}] run kill @s 
execute as @e[type=item,nbt={Item:{id:"minecraft:book",Count:1b,tag:{display:{Name:"{\"text\":\"heal\"}"}}}}] run kill @s

execute as @e[type=item,nbt={Item:{id:"minecraft:porkchop",Count:1b}}] at @e[type=item,nbt={Item:{id:"minecraft:porkchop",Count:1b}}] if block ~ ~-1 ~ minecraft:magma_block run scoreboard players add @s cook 1
execute as @e[scores={cook=1200..},type=item,nbt={Item:{id:"minecraft:porkchop",Count:1b}}] at @e[type=item,nbt={Item:{id:"minecraft:porkchop",Count:1b}}] if block ~ ~-1 ~ minecraft:magma_block run summon minecraft:item ~ ~ ~ {Item:{id:"minecraft:cooked_porkchop",Count:1b}}
execute as @e[scores={cook=1200..},type=item,nbt={Item:{id:"minecraft:porkchop",Count:1b}}] at @e[type=item,nbt={Item:{id:"minecraft:porkchop",Count:1b}}] run kill @s

execute as @e[type=item,nbt={Item:{id:"minecraft:beef",Count:1b}}] at @e[type=item,nbt={Item:{id:"minecraft:beef",Count:1b}}] if block ~ ~-1 ~ minecraft:magma_block run scoreboard players add @s cook 1
execute as @e[scores={cook=1200..},type=item,nbt={Item:{id:"minecraft:beef",Count:1b}}] at @e[type=item,nbt={Item:{id:"minecraft:beef",Count:1b}}] if block ~ ~-1 ~ minecraft:magma_block run summon minecraft:item ~ ~ ~ {Item:{id:"minecraft:cooked_beef",Count:1b}}
execute as @e[scores={cook=1200..},type=item,nbt={Item:{id:"minecraft:beef",Count:1b}}] at @e[type=item,nbt={Item:{id:"minecraft:beef",Count:1b}}] at @e[type=item] run kill @s

execute as @e[type=item,nbt={Item:{id:"minecraft:nether_star",Count:1b}}] at @e[type=item,nbt={Item:{id:"minecraft:nether_star",Count:1b}}] if block ~ ~-1 ~ minecraft:beacon run scoreboard players add @s cook 1
execute as @e[scores={cook=200..},type=item,nbt={Item:{id:"minecraft:nether_star",Count:1b}}] at @e[type=item,nbt={Item:{id:"minecraft:nether_star",Count:1b}}] if block ~ ~-1 ~ minecraft:beacon run tag @p add star
execute as @e[scores={cook=200..},type=item,nbt={Item:{id:"minecraft:nether_star",Count:1b}}] run kill @s

execute as @e[type=item,nbt={Item:{id:"minecraft:netherite_block",Count:1b}}] at @e[type=item,nbt={Item:{id:"minecraft:netherite_block",Count:1b}}] if block ~ ~-1 ~ minecraft:beacon run scoreboard players add @s cook 1
execute as @e[scores={cook=200..},type=item,nbt={Item:{id:"minecraft:netherite_block",Count:1b}}] at @e[type=item,nbt={Item:{id:"minecraft:netherite_block",Count:1b}}] if block ~ ~-1 ~ minecraft:beacon run tag @p add netherite
execute as @e[scores={cook=200..},type=item,nbt={Item:{id:"minecraft:netherite_block",Count:1b}}] run kill @s

execute as @e[type=item,nbt={Item:{id:"minecraft:end_crystal",Count:1b}}] at @e[type=item,nbt={Item:{id:"minecraft:end_crystal",Count:1b}}] if block ~ ~-1 ~ minecraft:beacon run scoreboard players add @s cook 1
execute as @e[scores={cook=200..},type=item,nbt={Item:{id:"minecraft:end_crystal",Count:1b}}] at @e[type=item,nbt={Item:{id:"minecraft:end_crystal",Count:1b}}] if block ~ ~-1 ~ minecraft:beacon run tag @p add endcrystal
execute as @e[scores={cook=200..},type=item,nbt={Item:{id:"minecraft:end_crystal",Count:1b}}] run kill @s

execute as @e[type=item,nbt={Item:{id:"minecraft:ender_eye",Count:1b}}] at @e[type=item,nbt={Item:{id:"minecraft:ender_eye",Count:1b}}] if block ~ ~-1 ~ minecraft:beacon run scoreboard players add @s cook 1
execute as @e[scores={cook=200..},type=item,nbt={Item:{id:"minecraft:ender_eye",Count:1b}}] at @e[type=item,nbt={Item:{id:"minecraft:ender_eye",Count:1b}}] if block ~ ~-1 ~ minecraft:beacon run tag @p add endeye
execute as @e[scores={cook=200..},type=item,nbt={Item:{id:"minecraft:ender_eye",Count:1b}}] run kill @s

execute at @e[type=item] if block ~ ~-1 ~ minecraft:magma_block run particle minecraft:flame ~ ~.5 ~
execute at @e[type=item] if block ~ ~-1 ~ minecraft:beacon run particle minecraft:soul_fire_flame ~ ~.5 ~
execute at @e[type=item] if block ~ ~-1 ~ minecraft:magma_block run playsound minecraft:block.blastfurnace.fire_crackle neutral @a ~ ~ ~ 0.75 
execute at @e[type=item] if block ~ ~-1 ~ minecraft:beacon run playsound minecraft:entity.enderman.teleport neutral @a ~ ~ ~ 0.03 0.0