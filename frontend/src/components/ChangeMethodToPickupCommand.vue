<template>

    <v-card outlined>
        <v-card-title>
            ChangeMethodToPickup
        </v-card-title>

        <v-card-text>
            <String label="PickupMethod" v-model="value.pickupMethod" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="changeMethodToPickup"
            >
                ChangeMethodToPickup
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'ChangeMethodToPickupCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.pickupMethod = '';
        },
        watch: {
        },
        methods: {
            changeMethodToPickup() {
                this.$emit('changeMethodToPickup', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

