<template>
    <v-container grid-list-md text-xs-center>
        <v-layout row wrap align-center justify-center>
            <v-flex xs8 mt-5>
                <v-card class="elevation-10" ref="form" v-model="valid" lazy-validation>
                    <v-card-title primary-title>
                        <div class="headline">Hello, user! Please, enter your value one by one.</div>
                    </v-card-title>
                    <v-form>
                        <v-layout align-center justify-space-around row fill-height>
                            <v-flex xs4 ml-5>
                                <v-text-field
                                        label="Solo"
                                        placeholder="Placeholder"
                                        solo
                                        v-model="answer"
                                        :rules="answerRules"
                                        counter="18"
                                ></v-text-field>
                            </v-flex>
                            <v-flex>
                                <v-btn @click="addToList" :disabled="!valid" color="#4A76A8">Add to list
                                </v-btn>
                                <v-btn @click="submit" color='green'>Send
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

        </v-layout>
    </v-container>
</template>

<script>

    import http from "../http-common";

    export default {
        data: () => ({
            result: 'result',
            results: {},
            message: '',
            lost: false,
            answer: '',
            answers: [],
            valid: true,
            answerRules: [
                (v) => !!v || 'The number is required',
                (v) => v && v.length <= 18 || 'The number must be less than 18 characters'
            ],
            status: ''
        }),

        methods: {
            submit() {

                http.get('/fizzBuzz/'+ this.answers)
                    .then(response =>
                        (this.results = response.data,
                                this.status = response.status,
                                console.log(JSON.stringify(response.status))
                        ))
                    .catch(
                        error => console.log(error),
                    );

            },
            addToList() {
                this.answers.push(this.answer);
            },
            clear() {
                this.answers = [];
                this.results = [];
            }
        },
    }
</script>

<style>

</style>
