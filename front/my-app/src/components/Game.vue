<template>
    <v-container grid-list-md text-xs-center>
        <v-layout row wrap align-center justify-center>
            <v-flex xs8 mt-5>
                <v-card class="elevation-10" ref="form" v-model="valid" lazy-validation>
                    <v-card-title  primary-title ><div class="headline">Hello, user! Please, enter your value one by one.</div></v-card-title>
                    <v-form>
                        <v-layout align-center justify-space-around row fill-height>
                            <v-flex xs4 ml-5>
                                <v-text-field
                                        label="Solo"
                                        placeholder="Placeholder"
                                        solo
                                        v-model="answer"
                                        counter="16"
                                ></v-text-field>
                            </v-flex>
                            <v-flex>
                                <v-btn @click="addToList" :disabled="!valid" color ="#4A76A8">Add to list
                                </v-btn>
                                <v-btn @click="submit" :disabled="!valid" color = 'green'>Send
                                </v-btn>
                                <v-btn @click="clear">clear</v-btn>
                            </v-flex>
                        </v-layout>
                        <v-item-group multiple>
                            <v-subheader>Your List:</v-subheader>
                            <v-item
                                    v-for="item in answers"
                                    :key="item.id"
                            >
                                <v-chip
                                        slot-scope="{ active, toggle }"
                                        :selected="active"
                                        @click="toggle"
                                >
                                    {{ item }}
                                </v-chip>
                            </v-item>
                        </v-item-group>
                    </v-form>
                    <v-item-group multiple>
                        <v-subheader>Answers:</v-subheader>
                        <v-item
                                v-for="tem in results.replacedList"
                                :key="tem.id"
                        >
                            <v-chip
                                    slot-scope="{ active, toggle }"
                                    :selected="active"
                                    @click="toggle"
                            >
                                {{ tem }}
                            </v-chip>
                        </v-item>
                    </v-item-group>
                </v-card>

            </v-flex>
            <!--<v-layout justify-center>-->
                <!--<v-flex xs6 mt-5>-->
                    <!--<v-card class="elevation-10">-->
                        <!--<v-card-title> <div class="headline">The answers:</div></v-card-title>-->
                        <!--<v-list two-line>-->
                            <!--<template v-for="(tem, index) in results.replacedList">-->

                                <!--<v-subheader-->
                                        <!--:key="index"-->
                                <!--&gt;-->
                                    <!--{{ tem }}-->
                                <!--</v-subheader>-->

                            <!--</template>-->
                        <!--</v-list>-->
                        <!--&lt;!&ndash;<div>{{tem}}</div>&ndash;&gt;-->

                    <!--</v-card>-->
                <!--</v-flex>-->
            <!--</v-layout>-->

        </v-layout>
    </v-container>
</template>

<script>
    import http from "../http-common";

    export default {
        data: () => ({
            result: 'result',
            results:{},
            message:'',
            lost: false,
            answer: '',
            answers:[]
        }),

        methods: {
            submit () {
                http.post('/fizzBuzz', this.answers)
                    .then(response => (this.results = response.data))
                    .catch(error => console.log(error));
                console.log(JSON.stringify(this.results))
            },
            addToList(){
                this.answers.push(this.answer);
            },
            clear () {
                this.answers = [];
                this.results = [];
            }
        },

        // computed: {
        //     // геттер вычисляемого значения
        //     lost: function () {
        //         return this.$router.push("LostPage");
        //     }
        //   }
    }
</script>

<style>

</style>
