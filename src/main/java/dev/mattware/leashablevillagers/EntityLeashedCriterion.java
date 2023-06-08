package dev.mattware.leashablevillagers;

import com.google.gson.JsonObject;
import net.minecraft.advancement.criterion.AbstractCriterion;
import net.minecraft.advancement.criterion.AbstractCriterionConditions;
import net.minecraft.entity.Entity;
import net.minecraft.loot.context.LootContext;
import net.minecraft.predicate.entity.AdvancementEntityPredicateDeserializer;
import net.minecraft.predicate.entity.AdvancementEntityPredicateSerializer;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.entity.LootContextPredicate;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class EntityLeashedCriterion extends AbstractCriterion<EntityLeashedCriterion.Conditions> {

    static final Identifier ID = new Identifier("leashablevillagers", "entity_leashed");

    public EntityLeashedCriterion() { }

    @Override
    protected Conditions conditionsFromJson(JsonObject obj, LootContextPredicate playerPredicate, AdvancementEntityPredicateDeserializer predicateDeserializer) {
        LootContextPredicate lootContextPredicate2 = EntityPredicate.contextPredicateFromJson(obj, "entity", predicateDeserializer);
        return new EntityLeashedCriterion.Conditions(playerPredicate, lootContextPredicate2);
    }

    @Override
    public Identifier getId() {
        return ID;
    }

    public void trigger(ServerPlayerEntity player, Entity entity) {
        LootContext lootContext = EntityPredicate.createAdvancementEntityLootContext(player, entity);
        this.trigger(player, (conditions) -> {
            return conditions.matches(lootContext);
        });
    }

    public static class Conditions extends AbstractCriterionConditions {
        private final LootContextPredicate entity;

        public Conditions(LootContextPredicate player, LootContextPredicate entity) {
            super(EntityLeashedCriterion.ID, player);
            this.entity = entity;
        }

        public static EntityLeashedCriterion.Conditions create(EntityPredicate.Builder leashedEntityBuilder) {
            return new EntityLeashedCriterion.Conditions(LootContextPredicate.EMPTY, EntityPredicate.asLootContextPredicate(leashedEntityBuilder.build()));
        }

        public boolean matches(LootContext leashedEntityContext) {
            return this.entity.test(leashedEntityContext);
        }

        public JsonObject toJson(AdvancementEntityPredicateSerializer predicateSerializer) {
            JsonObject jsonObject = super.toJson(predicateSerializer);
            jsonObject.add("entity", this.entity.toJson(predicateSerializer));
            return jsonObject;
        }
    }
}
