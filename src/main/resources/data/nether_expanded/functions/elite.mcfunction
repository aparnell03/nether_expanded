tag @e[scores={elite=1500..},tag=!promote] add elite
tag @e[scores={promote=1200..},tag=!elite] add promote
scoreboard players add @e[type=minecraft:piglin,limit=1,sort=random,tag=!elite] elite 1
scoreboard players set @e[type=minecraft:piglin,distance=..100,tag=!elite] elite 0
scoreboard players add @e[type=minecraft:wither_skeleton,tag=!elite] elite 0
scoreboard players set @e[type=minecraft:wither_skeleton,distance=..100,tag=!elite] elite 0
execute at @e[tag=elite,type=piglin] run scoreboard players add @e[tag=!promote,type=minecraft:piglin,limit=1,sort=random,distance=..100] promote 1
execute at @e[tag=elite,type=piglin] run scoreboard players add @e[tag=!promote,type=minecraft:piglin,limit=1,sort=nearest,distance=..100] promote 1
execute at @e[tag=elite,type=wither_skeleton] run scoreboard players add @e[tag=!promote,type=minecraft:wither_skeleton,limit=1,sort=random,distance=..100] promote 1
execute at @e[tag=elite,type=wither_skeleton] run scoreboard players add @e[tag=!promote,type=minecraft:wither_skeleton,limit=1,sort=nearest,distance=..100] promote 1
data merge entity @e[limit=1,tag=elite,type=minecraft:piglin] {HandItems:[{Count:1,id:netherite_sword},{Count:1,id:shield}],ArmorItems:[{Count:1,id:netherite_boots},{Count:1,id:netherite_leggings},{Count:1,id:netherite_chestplate},{Count:1,id:netherite_helmet}],HandDropChances:[0.0f,0.0f],ArmorDropChances:[0.0f,0.0f,0.0f,0.0f],CustomName:"\"Piglin Captain\""}
data merge entity @e[limit=1,tag=elite,type=minecraft:wither_skeleton] {HandItems:[{Count:1,id:netherite_sword},{Count:1,id:shield}],ArmorItems:[{Count:1,id:netherite_boots},{Count:1,id:netherite_leggings},{Count:1,id:netherite_chestplate},{Count:1,id:netherite_helmet}],HandDropChances:[0.0f,0.0f],ArmorDropChances:[0.0f,0.0f,0.0f,0.0f],CustomName:"\"Demonic Warlord\""}
data merge entity @e[limit=1,tag=promote,type=minecraft:piglin] {HandItems:[{Count:1,id:iron_sword},{Count:1,id:shield}],ArmorItems:[{Count:1,id:iron_boots},{Count:1,id:iron_leggings},{Count:1,id:iron_chestplate},{Count:1,id:iron_helmet}],HandDropChances:[0.0f,0.0f],ArmorDropChances:[0.0f,0.0f,0.0f,0.0f],CustomName:"\"Piglin Knight\""}
data merge entity @e[limit=1,tag=promote,type=minecraft:wither_skeleton] {HandItems:[{Count:1,id:iron_sword},{Count:1,id:shield}],ArmorItems:[{Count:1,id:iron_boots},{Count:1,id:iron_leggings},{Count:1,id:iron_chestplate},{Count:1,id:iron_helmet}],HandDropChances:[0.0f,0.0f],ArmorDropChances:[0.0f,0.0f,0.0f,0.0f],CustomName:"\"Demonic Warrior\""}